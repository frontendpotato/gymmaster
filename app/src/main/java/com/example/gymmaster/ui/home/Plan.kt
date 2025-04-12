package com.example.gymmaster.ui.home

import java.security.Timestamp

data class Plan(
    val title: String = "",
    val description: String = "",
    val image: String = "",
    val price: Double = 0.0,
    val durationDays: Int = 0,
    val tier: String = ""
)

data class ActivePlan(
    val title: String = "",
    val tier: String = "",
    val startDate: Timestamp? = null,
    val endDate: Timestamp? = null,
    val price: Double = 0.0,
    val planId: String = ""
)
