package com.banibegood.ulteam_gaming.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.banibegood.ulteam_gaming.MainActivity
import com.banibegood.ulteam_gaming.R
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
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
