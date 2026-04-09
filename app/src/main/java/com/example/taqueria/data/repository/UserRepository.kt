package com.example.taqueria.data.repository

import com.example.taqueria.data.local.dao.UserDao
import com.example.taqueria.data.local.entities.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserRepository(private val userDao: UserDao) {
    suspend fun saveFromFirebase(firebaseUser: FirebaseUser){
        val user = User(
            uid = firebaseUser.uid,
            name = firebaseUser.displayName,
            email = firebaseUser.email,
            lastLogin = System.currentTimeMillis(),
            isLogged = true
        )
        userDao.insertUser(user)
    }

    suspend fun getLoggedUser(): User?{
        return userDao.getLoggedUser()
    }

    suspend fun logout(){
        FirebaseAuth.getInstance().signOut()
        userDao.logout()
    }
}