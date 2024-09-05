package com.example.viewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: viewmodel

    lateinit var textCounter: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel=ViewModelProvider(this).get(viewmodel::class.java)

        textCounter=findViewById(R.id.textCounter)
        setText()
    }

    fun setText(){
        textCounter.text=mainViewModel.count.toString()
    }
    fun increment(){
        mainViewModel.increment()
        setText()
    }
}