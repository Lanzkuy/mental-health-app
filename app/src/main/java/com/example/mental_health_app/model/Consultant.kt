package com.example.mental_health_app.model

data class Consultant(
    val id: Int,
    val profilePicture: Int,
    val name: String,
    val role: Int,
    val totalPatient: Int,
    val experience: Int,
    val rating: Double,
    val consultPrice: Double,
    val biography: String,
    val status: Int
)
