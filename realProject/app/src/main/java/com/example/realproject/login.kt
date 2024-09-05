package com.example.realproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {



    private lateinit var edtEmail: EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnlogin:Button
    private lateinit var btnlogout:Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        mAuth= FirebaseAuth.getInstance()

        edtEmail=findViewById(R.id.edit_email)
        edtPassword=findViewById(R.id.edit_password)
        btnlogin=findViewById(R.id.btn_login)
        btnlogout=findViewById(R.id.btn_loguot)

        btnlogout.setOnClickListener {
            val intent=Intent(this,logout::class.java)
            startActivity(intent)


        }

        btnlogin.setOnClickListener {
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()
            login(email,password)
        }




    }

    private fun login(email: String,password:String) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
                Task-> if (Task.isSuccessful){

            val intent=Intent(this,MainActivity::class.java)
            finish()
            startActivity(intent)
        }
        else{

            Toast.makeText(this,"some error occure", Toast.LENGTH_SHORT).show()

        }
        }



    }
}