package com.example.taqueria.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taqueria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        listenerAddBtn()
        listenerLoginBtnEmail()

    }



    private fun setupBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun openActivity(activity: Class<*>){
        startActivity(Intent(this,activity))
        finish()
    }

    private fun listenerAddBtn(){
        binding.btnAddAccount.setOnClickListener { openActivity(LogUpActivity::class.java) }
    }

    private fun listenerLoginBtnEmail(){
        binding.btnLogin.setOnClickListener { openActivity(LoginActivity::class.java) }
    }


}