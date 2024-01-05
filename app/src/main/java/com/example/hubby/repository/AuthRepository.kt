package com.example.hubby.repository

import com.example.hubby.data.model.User
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository {

    val currentUser: FirebaseUser? = Firebase.auth.currentUser

    fun hasUser(): Boolean = Firebase.auth.currentUser != null

    fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()

    suspend fun createUser(
        email: String,
        password: String,
        name: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val userId = it.result?.user?.uid.orEmpty()
                    val user = User(userId, name, email)
                    addUserToDatabase(userId, user) { success ->
                        onComplete.invoke(success)
                    }
                } else {
                    onComplete.invoke(false)
                }
            }.await()

    }

    suspend fun login(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    onComplete.invoke(true)
                } else {
                    onComplete.invoke(false)
                }
            }.await()
    }

    private fun addUserToDatabase(userId: String, user: User, onComplete: (Boolean) -> Unit) {
        Firebase.firestore.collection("users").document(userId)
            .set(user)
            .addOnSuccessListener {
                onComplete.invoke(true)
            }
            .addOnFailureListener {
                onComplete.invoke(false)
            }
    }

    fun signOut() = Firebase.auth.signOut()

}