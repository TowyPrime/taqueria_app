package com.example.taqueria.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.taqueria.R
import com.example.taqueria.databinding.ActivityLogUpBinding
import com.example.taqueria.utils.AppInterfaces

class LogUpActivity : AppCompatActivity(), AppInterfaces {

    private lateinit var binding: ActivityLogUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       setupBinding()

       showTlbBututtons(true)
        listenerBtnBack()
        listenerBtnCancel()
        setupToolbar()

        }

    private fun setupBinding(){
        binding = ActivityLogUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.tlb)


        binding.tlb.setNavigationOnClickListener {
            openActivity(MainActivity::class.java)
        }
    }


    override fun showTlbBututtons(show: Boolean) {

    }



    override fun openActivity(activity: Class<*>) {
       startActivity(Intent(this, activity))
        finish()
    }

    override fun listenerBtnBack() {

    }

    override fun listenerBtnSettings() {

    }

    private fun listenerBtnCancel(){
        binding.btnCancel.setOnClickListener {
            openActivity(MainActivity::class.java)
        }
    }

    private fun showMenu(){

    }


}



