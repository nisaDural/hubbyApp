package com.example.hubby.repository

import com.example.hubby.data.model.Workshop
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class WorkshopRepository {
    private var operationSuccessful = false
    fun getAllWorkshops(): Flow<Response<List<Workshop>>> = callbackFlow {
        Response.Loading
        val snapshotListener = Firebase.firestore.collection("workshops")
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val workshopList = snapshot.toObjects(Workshop::class.java)
                    Response.Success<List<Workshop>>(workshopList)
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
