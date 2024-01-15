package com.example.hubby.repository

import com.example.hubby.data.model.Workshop
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

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

    fun uploadWorkshop(
        type: String,
        image: String,
        title: String,
        date: String,
        category: String,
        description: String,
        place: String,
        maxPerson: Int,
        userId: String
    ): Flow<Response<Boolean>> = flow {
        operationSuccessful = false
        try {
            val id = Firebase.firestore.collection("workshops").document().id
            val workshop = Workshop(
                id = id,
                image = image,
                title = title,
                date = date,
                category = category,
                description = description,
                place = place,
                maxPerson = maxPerson,
                type = type,
                userId = userId
            )
            Firebase.firestore.collection("workshops").document(id).set(workshop)
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
}
