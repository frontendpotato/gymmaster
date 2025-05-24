package com.example.gymmaster.ui.home

import java.io.Serializable

data class Service(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val images: List<String> = listOf(),
    val capacity: Int = 0
) : Serializable 