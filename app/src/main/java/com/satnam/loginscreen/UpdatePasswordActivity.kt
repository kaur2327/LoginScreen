package com.satnam.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class UpdatePasswordActivity : AppCompatActivity() {

     lateinit var resetpswd : TextView
     lateinit var password: EditText
     lateinit var confirmpswd : EditText
     lateinit var update : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        supportActionBar?.title = "Back"

        resetpswd = findViewById(R.id.resetpswd)
        password = findViewById(R.id.password)
        confirmpswd = findViewById(R.id.confirmpswd)
        update = findViewById(R.id.update)

        update.setOnClickListener {
            if(password.text.toString().isNullOrEmpty()){
                password.error = "Password must be filled up"
            }else if(password.text.length < 6){
                password.error = "Password must be of 6 characters"
            }else if(confirmpswd.text.toString().isNullOrEmpty()){
                confirmpswd.error = "Rewrite password for confirmation"
            }else if(!password.getText().toString().equals(confirmpswd.getText().toString())){
                Toast.makeText( this, "password must match",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText( this, "password has changed successfully!",Toast.LENGTH_LONG).show()
                val  intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}