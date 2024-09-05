package com.example.factorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                val num1 = findViewById(R.id.ed1) as EditText


                val tot = findViewById(R.id.ed2)  as EditText

                val fac = findViewById(R.id.ed3)  as EditText

                val b1 = findViewById(R.id.btn1)  as Button

                val b2 = findViewById(R.id.btn2)  as Button
                val b3 = findViewById(R.id.btn3)  as Button

                b1.setOnClickListener{

                    val val1 = num1.text.toString().toInt()


                    val result = val1 * val1;

                    tot.setText(result.toString())


                }
                b2.setOnClickListener{

                    val num = num1.text.toString().toInt()

                    var factorial: Long = 1
                    for (i in 1..num) {

                        factorial *= i.toLong()
                    }

                    fac.setText(factorial.toString())


                }

                b3.setOnClickListener{

                    var num = num1.text.toString().toInt()


                    var re = 0

                    5
                    fac.setText(re.toString())
                    tot.setText(re.toString())
                    num1.setText(re.toString())





        }
    }
}