package com.nehir.hubbylogin.ui.Screen

// import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(){
  var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkBoxOneState by remember { mutableStateOf(true) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        // .padding(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Sign Up",
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.TopCenter)
        )
        TextButton(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
        ) {
            Text(
                "Login",
                //color = Color.Black,
                color = Color(0xFFC9F299),
                fontSize = 18.sp
            )
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // X
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(Icons.Default.Close, contentDescription = "Close")
            //Icon(painter = painterResource(id = R.drawable.X), contentDescription = "")
        }
    }
    Column(
        //  horizontalAlignment = Alignment.CenterHorizontally,
        //  modifier = Modifier.fillMaxSize()
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = username, onValueChange = { username = it },
            label = {
                Text(text = "Name", color = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 110.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
        )
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = {
                Text(text = "Email", color = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
        )
        OutlinedTextField(
            value = password, onValueChange = { email = it },
            label = {
                Text(text = "Password", color = Color.Gray)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 10.dp),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),

        )
        Row (
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = checkBoxOneState , onCheckedChange ={checkBoxOneState = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Gray
                ),


                )
            Spacer(modifier = Modifier.width(6.dp))
            Text( text = buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)){
                    append("I would like to received your newsletter and other promotional information.")
                }
            },
                color = Color.Unspecified,
                fontSize = 12.sp
                ) 

        }

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
               // renk
              containerColor =Color(0xFFC9F299) , Color(0xFF9CBFA7)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 10.dp),
            contentPadding = PaddingValues(vertical = 18.dp),
            ) {
            Text(
                text = "Sign Up",
              fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
        }
        Spacer(modifier = Modifier.height(10.dp))
       Column (
           modifier =Modifier
               .padding(horizontal = 30.dp)
               .padding(top = 20.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally

       ){

            Text(
                text = "By clicking Sign Up, you agree to Hubby's Terms of Use and Privacy Policy.",
                fontSize = 15.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Default

                ),
                color = Color.Black

            ) }
        Spacer(modifier = Modifier.height(180.dp))


        Text(
            text = "Hubby",
            fontSize = 35.sp,
            style = TextStyle(fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif),
            color = Color.Black

        )


    }

}






@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen()
}