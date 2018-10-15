package com.pratikkarki.toolbar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_about -> {
                Toast.makeText(this, "ABOUT", Toast.LENGTH_LONG).show()
            }

            R.id.action_help -> {
                Toast.makeText(this, "HELP", Toast.LENGTH_LONG).show()

            }

            R.id.action_bottom_nav -> {
                startActivity(
                        Intent(this, BottomNavActivity::class.java))
            }

            R.id.action_navdrawer -> {
                startActivity(
                        Intent(this, NavDrawerActivity::class.java))
            }
        }

        return true
    }

}
