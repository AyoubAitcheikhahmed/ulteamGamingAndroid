package com.banibegood.ulteam_gaming.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.navigation.Navigation
import com.banibegood.ulteam_gaming.MainActivity
import com.banibegood.ulteam_gaming.R
import com.banibegood.ulteam_gaming.databinding.ActivityLoginBinding
import com.banibegood.ulteam_gaming.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)
        }

    fun onLogin(view: View) {

//       Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}





