package com.example.hubby.data.model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserViewModel : ViewModel() {
    private val _state = mutableStateOf(User())
    val state: State<User> = _state
    private val errorMessage = mutableStateOf<String?>(null)

    private val db = FirebaseFirestore.getInstance()
    private lateinit var listenerRegistration: ListenerRegistration

    init {
        getData()
        setupFirestoreListener()
    }

    suspend fun getDataFromFireStore(): User {
        var user = User()

        try {
            db.collection("user").get().await().map {
                val result = it.toObject(User::class.java)
                user = result
            }
        } catch (e: FirebaseFirestoreException) {
            Log.d("error", "getDataFromFireStore: $e")
        }
        return user
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                _state.value = getDataFromFireStore()
            } catch (e: Exception) {
                errorMessage.value = "Veri alınamadı: ${e.message}"
                Log.e("HomeViewModel", "getData: Veri alınamadı", e)
            }
        }
    }

    private fun setupFirestoreListener() {
        listenerRegistration = db.collection("user")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Log.e("HomeViewModel", "Firestore listener error", error)
                    return@addSnapshotListener
                }

                if (value != null) {
                    val userList = value.toObjects(User::class.java)
                    if (userList.isNotEmpty()) {
                        _state.value = userList[0]
                    }
                }
            }
    }

    override fun onCleared() {
        super.onCleared()
        // Remove the Firestore listener when the ViewModel is cleared
        listenerRegistration.remove()
    }
}
