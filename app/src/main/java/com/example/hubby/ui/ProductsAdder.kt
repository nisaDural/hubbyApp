@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hubby.ui

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.hubby.data.model.ProductViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.util.UUID

@Composable
fun ProductsAdder(
    productViewModel: ProductViewModel
) {

    val userId = Firebase.auth.currentUser!!.uid

    var selectedColor by remember { mutableStateOf(Color.Gray) }

    val isUploading = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    val img: Bitmap =
        BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
    val bitmap = remember { mutableStateOf(img) }

    val launchImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        if (Build.VERSION.SDK_INT < 28) {
            bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
        } else {
            val source = it?.let { it1 ->
                ImageDecoder.createSource(context.contentResolver, it1)
            }
            bitmap.value = source?.let { it1 ->
                ImageDecoder.decodeBitmap(it1)
            }!!
        }
    }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Name
        val name = remember { mutableStateOf("") }
        TextField(value = name.value, onValueChange = { name.value = it }, label = { Text("Name") })

        // Category
        val category = remember { mutableStateOf("") }
        TextField(value = category.value,
            onValueChange = { category.value = it },
            label = { Text("Category") })

        // Price
        val price = remember { mutableStateOf("") }
        TextField(
            value = price.value,
            onValueChange = { price.value = it },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = androidx.compose.ui.text.input.ImeAction.Done
            )
        )

        // Description
        val description = remember { mutableStateOf("") }
        TextField(value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Description") })

        // Color Picker
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Show color picker dialog
            }
            .background(selectedColor)
            .padding(16.dp)) {
            Text("Color", color = Color.White)
        }

        // Size
        val size = remember { mutableStateOf("") }
        TextField(value = size.value, onValueChange = { size.value = it }, label = { Text("Size") })

        // Image Picker
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                launchImage.launch("image/*")
                showDialog = false
            }) {
            bitmap?.let {
                Image(
                    bitmap = bitmap.value.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(shape = MaterialTheme.shapes.medium)
                )
            }
        }
        // Save Button
        Button(
            onClick = {
                isUploading.value = true
                bitmap.value.let { bitmap ->
                    uploadImageToFirebase(bitmap, context as ComponentActivity) { imageUrl ->
                        if (imageUrl != null) {
                            productViewModel.uploadProduct(
                                image = imageUrl, // Replace with actual image URL or storage reference
                                description = description.value,
                                time = System.currentTimeMillis(),
                                name = name.value,
                                category = category.value,
                                price = 0.0,
                                colors = listOf(
                                    "Blue", "Green"
                                ), // Convert color to string or store color code
                                sizes = listOf("M", "L"),
                                starRating = 0, // You may set this based on user ratings later
                                unitsSold = 0, // You may update this based on actual sales data
                                userId = userId // Replace with actual user ID
                            )
                            isUploading.value = false

                        } else {
                            isUploading.value = false
                            Toast.makeText(context, "Failed to Upload Image", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.Check, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Save Product")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
        ) {
            if (isUploading.value) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp)
                )

            }
        }
    }


}

fun uploadImageToFirebase(
    bitmap: Bitmap,
    context: ComponentActivity,
    callback: (String?) -> Unit
) {
    val storageRef = Firebase.storage.reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}.jpg")

    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val imageData = baos.toByteArray()

    imageRef.putBytes(imageData).addOnSuccessListener { taskSnapshot ->

        taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
            callback(uri.toString())
        }.addOnFailureListener {
            callback(null)
        }
    }.addOnFailureListener {
        callback(null)
    }
}