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

    fun getAllWorkshops() {
        viewModelScope.launch {
            repository.getAllWorkshops().collect {
                _workshopData.value = it
            }
        }
    }
}
