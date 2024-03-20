package com.example.competitionapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignIn : AppCompatActivity() {

    private lateinit var signInBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signInBTN = findViewById(R.id.SignInBTN)
        signInBTN.setOnClickListener {
            val fragmentsHolderIntent = Intent(this, FragmentsHolder::class.java)
            startActivity(fragmentsHolderIntent)
        }
    }
}