package com.satnam.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var lg : TextView
    lateinit var email : EditText
    lateinit var pswd : EditText
    lateinit var FGpass : TextView
    lateinit var login : Button
    lateinit var register : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lg = findViewById(R.id.lg)
        email = findViewById(R.id.email)
        pswd = findViewById(R.id.pswd)
        FGpass = findViewById(R.id.FGpass)
        login = findViewById(R.id.login)
        register = findViewById(R.id.register)

        //moving to new for resetting password
        FGpass.setOnClickListener {
            var intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

        //validations
        login.setOnClickListener {
            if(email.text.toString().isNullOrEmpty()){
                email.error="It is mandatory to fill username"
            }else if(pswd.text.toString().isNullOrEmpty()){
                pswd.error="It is mandatory to fill password"
            }else if(pswd.text.length < 6) {
                pswd.error = "Password must be of 6 character"
            }else{
                Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
            }
        }
        register.setOnClickListener {
            var intent = Intent(this, RegisterActiviy::class.java)
            startActivity(intent)
            finish()
        }
    }
}