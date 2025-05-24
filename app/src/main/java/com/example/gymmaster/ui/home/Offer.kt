package com.example.gymmaster.ui.home

import java.io.Serializable

data class Offer(
    val id: String = "",
    val title: String = "",
    val price: String = "",
    val duration: String = "",
    val details: String = "",
    val persons: Int = 1
) : Serializable 