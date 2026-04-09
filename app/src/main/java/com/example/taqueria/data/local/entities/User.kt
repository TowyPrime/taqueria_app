package com.example.taqueria.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
data class User(
    @PrimaryKey val uid: String,
    val name: String?,
    val email: String?,
    val lastLogin: Long,
    val isLogged: Boolean
)
