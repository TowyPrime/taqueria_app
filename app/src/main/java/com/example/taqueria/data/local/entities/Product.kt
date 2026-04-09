package com.example.taqueria.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double,
    val categoryId: String,
    val isAvailable: Boolean
)
