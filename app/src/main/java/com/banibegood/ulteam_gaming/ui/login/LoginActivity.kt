package com.banibegood.ulteam_gaming.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.navigation.Navigation
import com.banibegood.ulteam_gaming.R
import com.banibegood.ulteam_gaming.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)


        binding.loginBtn.setOnClickListener{
            print("HELLO")
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
        }

        }

    fun onLogin(view: View) {

        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)

    }
}





