package com.example.hubby.repository

import com.example.hubby.data.model.Address
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AddressRepository {

    private var operationSuccessful = false

    fun getUserAddresses(userId: String): Flow<Response<List<Address>>> = callbackFlow {
        Response.Loading
        val snapshotListener = Firebase.firestore.collection("addresses")
            .whereEqualTo("userId", userId) // userId alanına göre filtreleme
            .addSnapshotListener { snapshot, e ->
                val response = if (snapshot != null) {
                    val addressList = snapshot.toObjects(Address::class.java)
                    Response.Success<List<Address>>(addressList)
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