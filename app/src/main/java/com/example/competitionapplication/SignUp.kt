package com.example.competitionapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

class SignUp : AppCompatActivity() {

    private lateinit var passwordET: EditText
    private lateinit var strengthTV: TextView
    private lateinit var signUpBTN: Button
    private var color: Int = R.color.weak
    private lateinit var loginTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        passwordET = findViewById(R.id.PasswordET)
        strengthTV = findViewById(R.id.StrengthTV)
        signUpBTN = findViewById(R.id.SignUpBTN)

        val passwordStrengthCalculator = PasswordStrengthCalculator()
        passwordET.addTextChangedListener(passwordStrengthCalculator)

        // Observers
        passwordStrengthCalculator.strengthLevel.observe(this, Observer {strengthLevel ->
            displayStrengthLevel(strengthLevel)
        })
        passwordStrengthCalculator.strengthColor.observe(this, Observer {strengthColor ->
            color = strengthColor
        })

        loginTV = findViewById(R.id.LoginTV)
        loginTV.setOnClickListener {
            val loginInIntent = Intent(this, SignIn::class.java)
            startActivity(loginInIntent)
        }
    }

    private fun displayStrengthLevel(strengthLevel: StrengthLevel) {
        signUpBTN.isEnabled = strengthLevel == StrengthLevel.BULLETPROOF

        strengthTV.text = strengthLevel.name
        strengthTV.setTextColor(ContextCompat.getColor(this, color))
    }

}