package com.example.competitionapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val signUpBTN: Button = findViewById(R.id.SignUpBTN)
        val signInBTN: Button = findViewById(R.id.SignInBTN)

        signInBTN.setOnClickListener {
            val signInIntent = Intent(this, SignIn::class.java)
            startActivity(signInIntent)
        }

        signUpBTN.setOnClickListener {
            val signUpIntent = Intent(this, SignUp::class.java)
            startActivity(signUpIntent)
        }
    }
}