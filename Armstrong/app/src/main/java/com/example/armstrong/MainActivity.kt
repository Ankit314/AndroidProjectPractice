package com.example.armstrong

import android.R.bool
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnCheck : Button
    lateinit var etNum : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val editText=findViewById<EditText>(R.id.String)
        val textView=findViewById<TextView>(R.id.output)
        val reversebtn=findViewById<Button>(R.id.reverse)
        val clearbtn=findViewById<Button>(R.id.clear)
        reversebtn.setOnClickListener {
            val reversestring=editText.text.toString().reversed()
            textView.text=reversestring
        }
        clearbtn.setOnClickListener {
            editText.text.clear()
            textView.text=""
        }


        // Binding the views
        btnCheck = findViewById(R.id.btnCheck)
        etNum = findViewById(R.id.etNum)

        btnCheck.setOnClickListener {
            val n = etNum.text.toString().length
            val num = etNum.text.toString().toInt()
            var temp = num
            var result = 0

            if (isAutomorphic(num))
                Toast.makeText(this, "Automorphic Number", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Not an Automorphic Number", Toast.LENGTH_SHORT).show()
        }

    }

    fun isAutomorphic(N: Int): Boolean {

        // Store the square
        var N = N
        var sq = N * N

        // Start Comparing digits
        while (N > 0) {
            // Return false, if any digit of N doesn't
            // match with its square's digits from last
            if (N % 10 != sq % 10) return false

            // Reduce N and square
            N /= 10
            sq /= 10
        }
        return true
    }

}
