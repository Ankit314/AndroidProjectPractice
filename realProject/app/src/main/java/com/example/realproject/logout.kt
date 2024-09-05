package com.example.realproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class logout : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var editName:EditText
    private lateinit var btnlogout: Button

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef:DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
        supportActionBar?.hide()

        mAuth= FirebaseAuth.getInstance()


        edtEmail=findViewById(R.id.edit_email)
        edtPassword=findViewById(R.id.edit_password)
        editName=findViewById(R.id.edit_name)
        btnlogout=findViewById(R.id.btn_loguot)


        btnlogout.setOnClickListener {
            val name=editName.text.toString()
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()
            logout(email,password,name)
        }




    }

    private fun logout(email: String,password:String,name:String) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){
            Task-> if (Task.isSuccessful){

                addUserToDatabase(name,email,mAuth.currentUser?.uid!!)

                val intent=Intent(this,MainActivity::class.java)

                finish()
                startActivity(intent)
        }
            else{

                Toast.makeText(this,"some error occure",Toast.LENGTH_SHORT).show()

        }
        }

    }
    private fun addUserToDatabase(name: String,email: String,uid:String){

        mDbRef=FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(name,email,uid))

    }
}