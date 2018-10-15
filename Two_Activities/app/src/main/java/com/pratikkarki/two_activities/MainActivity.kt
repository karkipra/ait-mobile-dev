package com.pratikkarki.two_activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    companion object { //Companion means that it can be accessed in other classes as well
        val KEY_DATA = "KEY_DATA"
        val REQUEST_DETAILS = 1001
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newActivity()
    }

    fun runSecondActivity(){
        val myIntent = Intent() // You have to set an intent for the next activity to check back with this one
        myIntent.setClass(this@MainActivity,
                DetailsActivity::class.java)
        // Send data back to the other activity


        myIntent.putExtra(KEY_DATA, etData.text.toString())

        //startActivity(myIntent)

        startActivityForResult(myIntent, REQUEST_DETAILS)
    }

    fun newActivity(){
        btnSubmit.setOnClickListener{
            runSecondActivity()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_DETAILS) {
            if (resultCode == Activity.RESULT_OK) {
                var content = data?.getStringExtra("KEY_MY_RESULT")
                Toast.makeText(this, content, Toast.LENGTH_LONG).show()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "REQUEST CANCELLED", Toast.LENGTH_LONG).show()
            }
        }
    }
}
