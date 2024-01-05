package com.example.hubby.repository

import com.example.hubby.data.model.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class ProductRepository {
    private var operationSuccessful = false
    fun getAllProducts(): Flow<Response<List<Product>>> = callbackFlow {
        Response.Loading
        val snapshotListener = Firebase.firestore.collection("products")
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val productList = snapshot.toObjects(Product::class.java)
                    Response.Success<List<Product>>(productList)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }

    fun uploadProduct(
        image: String,
        description: String,
        time: Long,
        name: String,
        category: String,
        price: Double,
        colors: List<String>?,
        sizes: List<String>?,
        starRating: Int,
        unitsSold: Int,
        userId: String,
    ): Flow<Response<Boolean>> = flow {
        operationSuccessful = false
        try {
            val id = Firebase.firestore.collection("products").document().id
            val product = Product(
                id = id,
                image = image,
                description = description,
                time = time,
                name = name,
                category = category,
                price = price,
                colors = colors,
                sizes = sizes,
                starRating = starRating,
                unitsSold = unitsSold,
                userId = userId,
            )
            Firebase.firestore.collection("products").document(id).set(product)
                .addOnSuccessListener {
                    operationSuccessful = true
                }.await()
            if (operationSuccessful) {
                emit(Response.Success(operationSuccessful))
            }


        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "An Unexpected error"))

        }

    }

    fun getUserProducts(userId: String): Flow<Response<List<Product>>> = callbackFlow {
        Response.Loading
        val snapshotListener = Firebase.firestore.collection("products")
            .whereEqualTo("userId", userId)
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val productList = snapshot.toObjects(Product::class.java)
                    Response.Success<List<Product>>(productList)
                } else {
                    Response.Error(e?.message ?: e.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapshotListener.remove()
        }
    }
}