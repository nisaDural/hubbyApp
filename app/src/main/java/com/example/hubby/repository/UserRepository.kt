package com.example.hubby.repository

import com.example.hubby.data.model.Product
import com.example.hubby.data.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

const val USER_COLLECTION_REF = "users"

class UserRepository() {
    private var operationSuccessful = false

    fun user() = Firebase.auth.currentUser

    fun hasUser(): Boolean = Firebase.auth.currentUser != null

    fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()

    private val userRef: CollectionReference = Firebase
        .firestore.collection(USER_COLLECTION_REF)

    fun getUserDetails(
        userId: String
    ): Flow<Response<User>> = callbackFlow {
        Response.Loading
        val snapShotListener = userRef
            .document(userId)
            .addSnapshotListener { snapshot, error ->
                val response = if (snapshot != null) {
                    val userInfo = snapshot.toObject(User::class.java)
                    Response.Success<User>(userInfo!!)
                } else {
                    Response.Error(error?.message ?: error.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose {
            snapShotListener.remove()
        }
    }

    fun updateUserDetails(
        userId: String,
        name: String,
        title: String?,
        categories: List<String>?,
        imageUrl: String?,
    ): Flow<Response<Boolean>> = flow {
        var operationSuccessful = false
        try {
            val userObj = mutableMapOf<String, Any?>(
                "name" to name,
                "title" to title,
                "categories" to categories,
                "imageUrl" to imageUrl,
            )
            Firebase.firestore.collection("users").document(userId).update(userObj)
                .addOnSuccessListener {
                    operationSuccessful = true
                }.await()
            if (operationSuccessful) {
                emit(Response.Success(operationSuccessful))
            } else {
                emit(Response.Error("Edit Does Not Succed"))
            }

        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "An Unexpected Error")
        }
    }

    fun addFavorite(
        productImg: String,
        productId: String,
        userId: String,
    ): Flow<Response<Boolean>> = flow {
        var operationSuccessful = false
        try {
            val favoriteProduct = Product(
                id = productId,
                image = productImg,
                userId = userId,
            )
            FirebaseFirestore.getInstance().collection("users")
                .document(userId)
                .collection("favorites").document(productId).set(favoriteProduct)
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

    fun removeFavorite(
        productId: String,
        userId: String,
    ): Flow<Response<Boolean>> = flow {
        var operationSuccessful = false
        try {
            val favoritesCollection = Firebase.firestore.collection("users")
                .document(userId)
                .collection("favorites")

            favoritesCollection.document(productId).delete().addOnSuccessListener {
                operationSuccessful = true
            }.await()
            if (operationSuccessful) {
                emit(Response.Success(operationSuccessful))
            }
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "An Unexpected error"))
        }
    }

    fun isFavorite(
        productId: String,
        userId: String,
    ): Flow<Response<Boolean>> = flow {
        var operationSuccessful = false
        try {
            val favoritesCollection = Firebase.firestore.collection("users")
                .document(userId)
                .collection("favorites")

            favoritesCollection.whereEqualTo("productId", productId).get().addOnSuccessListener {
                operationSuccessful = true
            }.await()
            if (operationSuccessful) {
                emit(Response.Success(operationSuccessful))
            }
        } catch (e: Exception) {
            emit(Response.Error(e.localizedMessage ?: "An Unexpected error"))
        }
    }


}


sealed class Response<out T> {
    object Loading : Response<Nothing>()

    data class Success<out T>(
        val data: T
    ) : Response<T>()

    data class Error(
        val message: String
    ) : Response<Nothing>()

    fun <R> map(transform: (T) -> R): Response<R> = when (this) {
        is Loading -> Loading
        is Success -> Success(transform(data))
        is Error -> Error(message)
    }
}