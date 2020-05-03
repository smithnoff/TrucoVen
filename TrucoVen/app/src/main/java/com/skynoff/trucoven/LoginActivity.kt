package com.skynoff.trucoven

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.skynoff.trucoven.ui.SingUpActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun OpenSingUpActivity(view: View) {
        startActivity(Intent(this, SingUpActivity::class.java))

    }
}
