package com.pratikkarki.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*



/*

    ====== Works fine. Things to fix: ========

    * Base case for no inputs
    * Sending pointer back to beginning after a calculation or clearance

*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input1 = findViewById<EditText>(R.id.num1)
        val input2 = findViewById<EditText>(R.id.num2)
        //val add = findViewById<Button>(R.id.add)
        //val minus = findViewById<Button>(R.id.minus)
        //val multiply = findViewById<Button>(R.id.multiply)
        //val divide = findViewById<Button>(R.id.divide)
        //val clear = findViewById<Button>(R.id.clear)

        //val result = findViewById<TextView>(R.id.result)



        add.setOnClickListener {
            if(!input1.text.toString().equals("")) {
                val a: String = input1.text.toString()
                val b: String = input2.text.toString()

                val res = a.toInt() + b.toInt()

                result.setText(res.toString())
            }
        }

        minus.setOnClickListener {
            val a: String = input1.text.toString()
            val b: String = input2.text.toString()

            val res = a.toInt() - b.toInt()

            result.setText(res.toString())
        }

        multiply.setOnClickListener {
            val a: String = input1.text.toString()
            val b: String = input2.text.toString()

            val res = a.toInt() * b.toInt()

            result.setText(res.toString())
        }

        divide.setOnClickListener {
            val a: String = input1.text.toString()
            val b: String = input2.text.toString()

            if (b.toInt() == 0) {
                result.setText("UNDEFINED")
            } else {

                val res = a.toFloat() / b.toFloat()
                result.setText(res.toString())
            }
        }

        clear.setOnClickListener {
            input1.setText("")
            input2.setText("")
            result.setText("")
        }

        /*

        Snackbar.make(layoutContent, time, Snackbar.LENGTH_LONG).show()

        Snackbar.make(layoutContent, time, Snackbar.LENGTH_LONG)
                .setAction("Clear") {
                    tvTime.text = ""
                }
                .show()

                */
    }


}
