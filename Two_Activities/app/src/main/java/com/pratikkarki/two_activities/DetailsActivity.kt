package com.pratikkarki.two_activities

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pratikkarki.two_activities.MainActivity.Companion.KEY_DATA
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Check who has started the activity
        if(intent.hasExtra(KEY_DATA) ){
            tvData.text = intent.getStringExtra(KEY_DATA)
        }


        btnOk.setOnClickListener {
            var intentResult = Intent()
            intentResult.putExtra("KEY_MY_RESULT", etResultData.text.toString())
            setResult(Activity.RESULT_OK, intentResult)
            finish()
        }
    }
}
