package com.example.basicproject



import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
    }


    fun Call(v: View?) {

        val e = findViewById<View>(R.id.editText) as EditText


        Toast.makeText(this, "clicked", Toast.LENGTH_LONG)
            .show()


        val u = Uri.parse("tel:" + e.text.toString())


        val i = Intent(Intent.ACTION_DIAL, u)
        try {

            startActivity(i)
        } catch (s: SecurityException) {

            Toast.makeText(this, "An error occurred", Toast.LENGTH_LONG)
                .show()
        }
    }
}
