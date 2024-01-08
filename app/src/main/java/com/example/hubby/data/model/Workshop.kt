package com.example.hubby.data.model

data class Workshop(
    val id: String? = null,
    val type: String? = null,
    val image: String? = null,
    val userName: String? = null,
    val userImg: String? = null,
    val title: String? = null,
    val date: String? = null,
    val category: String? = null,
    val status: String? = null,
    val description: String? = null,
    val time: String? = null,
    val place: String? = null,
    val maxPerson: Int? = null,
    val userId: String? = null,
    val participations: List<Participation>? = emptyList()
)

data class Participation(
    val userId: String? = null,
    val joinedDate: String? = null
)
