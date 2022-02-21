package com.cubidevs.bookproject.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cubidevs.bookproject.ui.register.RegisterActivity
import com.cubidevs.bookproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private  lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)

    loginBinding.registerTextView.setOnClickListener {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }


        setContentView(loginBinding.root)
    }
}