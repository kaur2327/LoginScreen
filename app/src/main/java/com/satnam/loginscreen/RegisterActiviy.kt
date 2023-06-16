package com.satnam.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActiviy : AppCompatActivity() {

    lateinit var register : TextView
    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var mobileno : EditText
    lateinit var password : EditText
    lateinit var confirmpswd : EditText
    lateinit var Register : Button
    lateinit var signin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activiy)

        supportActionBar?.title = "Registration"

        register = findViewById(R.id.register)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        mobileno = findViewById(R.id.mobileno)
        password = findViewById(R.id.password)
        confirmpswd = findViewById(R.id.confirmpswd)
        Register = findViewById(R.id.Register)
        signin = findViewById(R.id.signin)

        Register.setOnClickListener {
            if(name.text.toString().isEmpty()){
                name.error = "It is mandatory to fill in name"
            }else if(email.text.toString().isEmpty()){
                email.error = "It is mandatory to fill in email"
            }else if(password.text.toString().isEmpty()){
                password.error =  "It is mandatory to fill in password"
            }else if(password.text.length < 6){
                password.error = "Password must be of 6 character"
            }else if(mobileno.text.toString().isEmpty()){
                mobileno.error = "It is mandatory to fill in mobile no"
            }else if(mobileno.text.length < 10){
                mobileno.error = "mobile no must be 10 digits"
            }else if(!password.getText().toString().equals(confirmpswd.getText().toString())){
                Toast.makeText( this, "Passwords must match", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText( this, "Account has created successfully",Toast.LENGTH_LONG).show()
            }
        }

        signin.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}