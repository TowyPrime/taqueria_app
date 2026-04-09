package com.example.taqueria.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taqueria.data.local.entities.User
import com.example.taqueria.data.repository.UserRepository
import com.example.taqueria.presentation.state.UserState
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository
): ViewModel() {
    private val _userState = MutableStateFlow<UserState>(UserState.Idle)
    val userState: StateFlow<UserState> = _userState

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    init {
        checkLoggedUser()
    }

    //Verificar si hay usuario en cache
    private fun checkLoggedUser(){
        viewModelScope.launch {
            _userState.value = UserState.Loading

            try {
                val user = repository.getLoggedUser()

                if(user !=null){
                    _currentUser.value = user
                    _userState.value  = UserState.Success(user)
                }else{
                    _userState.value = UserState.Idle
                }
            }catch (e: Exception){
                _userState.value = UserState.Error(e.message?: "Error desconocido")
            }
        }
    }

//Guardar usuario después de login
fun saveUser(firebaseUser: FirebaseUser){
    viewModelScope.launch {
        _userState.value = UserState.Loading

        try {
            repository.saveFromFirebase(firebaseUser)

            val user = repository.getLoggedUser()
            _currentUser.value = user

            _userState.value = UserState.Success(user!!)

        }catch (e: Exception){
                _userState.value = UserState.Error(e.message?:"Error al guardar usuario")
        }
    }
}

    //Logout
    fun logout(){
        viewModelScope.launch {
            _userState.value = UserState.Loading

            try {
                repository.logout()
                _currentUser.value = null
                _userState.value = UserState.Idle
            }catch (e: Exception){
                    _userState.value = UserState.Error(e.message ?: "Error al cerrar sesión")
            }
        }
    }

}