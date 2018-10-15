package com.pratikkarki.highlow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start()
        help()
        about()
    }

    fun start(){
        btnstart.setOnClickListener{
            val intentGame = Intent()
            intentGame.setClass(MainActivity@this,
                    GameActivity::class.java)
            startActivity(intentGame)

        }
    }

    fun help(){
        btnhelp.setOnClickListener{

        }
    }

    fun about(){
        btnabout.setOnClickListener{

        }
    }


}
