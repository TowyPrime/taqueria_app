package com.example.taqueria.presentation.state

import com.example.taqueria.data.local.entities.User

sealed class UserState {
    object Idle: UserState()
    object Loading: UserState()
    data class Success(val user: User): UserState()
    data class Error(val message: String): UserState()
}