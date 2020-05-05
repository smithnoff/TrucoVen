package com.skynoff.trucoven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun OpenSingUpActivity(view: View) {
        startActivity(Intent(this, SingUpActivity::class.java))

    }

    fun OpenForgotPass(view: View) {
        startActivity(Intent(this, ForgotPass::class.java))

    }
}
