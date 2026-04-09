package com.example.taqueria.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taqueria.data.local.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE isLogged = 1 LIMIT 1")
    suspend fun getLoggedUser(): User?

    @Query("UPDATE users SET isLogged = 0")
    suspend fun logout()

}