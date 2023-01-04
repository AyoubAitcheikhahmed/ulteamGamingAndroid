package com.banibegood.ulteam_gaming.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.banibegood.ulteam_gaming.MainActivity
import com.banibegood.ulteam_gaming.R

class LoadActivity : AppCompatActivity() {

    private lateinit var constraintLayout : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        constraintLayout = findViewById(R.id.loadLayout)
        constraintLayout?.setOnClickListener(){
            val intent = Intent(this@LoadActivity,MainActivity::class.java)
            startActivity(intent)
        }


    }
}