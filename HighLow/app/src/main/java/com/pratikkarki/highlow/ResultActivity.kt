package com.pratikkarki.highlow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        etCount.text=getString(R.string.guesses)
    }

    override fun onBackPressed() {
        //Toast.makeText(this, "YOU CAN NOT GO BACK", Toast.LENGTH_LONG).show()

        var intentMain = Intent()
        intentMain.setClass(this, MainActivity::class.java)
        intentMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentMain)

        finish()
    }

    fun numberOfGuesses(){

    }
}
