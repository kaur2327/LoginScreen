package com.satnam.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class GenerateOTP : AppCompatActivity() {

    var email = ""
    var generateotp = ""
    lateinit var verificationpswd : TextView
    lateinit var numone : EditText
    lateinit var numtwo : EditText
    lateinit var numthree : EditText
    lateinit var numfour : EditText
    lateinit var verify : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_otp)

        supportActionBar?.title = "Back"

        intent?.extras?.let {
            email = it.getString("email", "")
        }

        verificationpswd = findViewById(R.id.verificationpswd)
        verificationpswd.setText(email)

        numone = findViewById(R.id.numone)
        numtwo = findViewById(R.id.numtwo)
        numthree = findViewById(R.id.numthree)
        numfour = findViewById(R.id.numfour)
        verify = findViewById(R.id.verify)

        numone.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0) > 0){
                numtwo.requestFocus()
            }
        }

        numtwo.doOnTextChanged { text, start, before, count ->
            if ((text?.length?:0) > 0){
                 numthree.requestFocus()
            }
        }

        numthree.doOnTextChanged { text, start, before, count ->
            if ((text?.length?:0) > 0){
                 numfour.requestFocus()
            }
        }

        generateotp = numone.text.toString() + numtwo.text.toString() + numthree.text.toString() + numfour.text.toString()

        verify.setOnClickListener {
            if((generateotp.length)<4){
                Toast.makeText(this, "otp is not complete",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent( this, UpdatePasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }
}