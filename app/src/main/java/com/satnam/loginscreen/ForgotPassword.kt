package com.satnam.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPassword : AppCompatActivity() {

    lateinit var email : EditText
    lateinit var generateotp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        supportActionBar?.title = "Back"

        email = findViewById(R.id.email)
        generateotp = findViewById(R.id.generateotp)

        generateotp.setOnClickListener {
            if (email.text.toString().isNullOrEmpty()){
                email.error="It is mandatory to fill email"
            }else{
                var intent = Intent( this, GenerateOTP::class.java)
                val email = email.text.toString()
                intent.putExtra( "email",email)
                startActivity(intent)
            }
        }


    }
}