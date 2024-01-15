package com.example.hubby.data.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubby.repository.Response
import com.example.hubby.repository.WorkshopRepository
import kotlinx.coroutines.launch

class WorkshopViewModel(
    private val repository: WorkshopRepository = WorkshopRepository()
) : ViewModel() {

    private val _workshopData = mutableStateOf<Response<List<Workshop>>>(Response.Loading)
    val workshopData: State<Response<List<Workshop>>> = _workshopData

    private val _uploadWorkshopData = mutableStateOf<Response<Boolean>>(Response.Success(false))
    val uploadWorkshopData: State<Response<Boolean>> = _uploadWorkshopData

    fun getAllWorkshops() {
        viewModelScope.launch {
            repository.getAllWorkshops().collect {
                _workshopData.value = it
            }
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
    ) {
        viewModelScope.launch {
            repository.uploadWorkshop(
                image = image,
                title = title,
                date = date,
                category = category,
                description = description,
                place = place,
                maxPerson = maxPerson,
                type = type,
                userId = userId
            ).collect {
                _uploadWorkshopData.value = it
            }
        }
    }
}
