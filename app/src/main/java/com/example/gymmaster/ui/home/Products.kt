package com.example.gymmaster.ui.home
import java.io.Serializable
import java.util.Date

data class Product(
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0,
    val createdAt: Date? = null,
    val updatedAt: Date? = null
) : Serializable
