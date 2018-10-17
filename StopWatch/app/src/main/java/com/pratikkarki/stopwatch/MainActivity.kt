package com.pratikkarki.stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var startTime = 0L
    var sdf = SimpleDateFormat("mm:ss:SSS")

    var enabled = false

    lateinit var timeTracker : String

    private inner class MyTimerTask : TimerTask() {
        override fun run() {
            runOnUiThread {
                if (enabled) {
                        timeTracker = sdf.format(Date(System.currentTimeMillis() - startTime))
                        timeValue.text = timeTracker
                }
            }
        }
    }

    private lateinit var mainTimer : Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartStop.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if(!enabled) {
                    mainTimer = Timer()
                    enabled = true
                    startTime = System.currentTimeMillis()
                    mainTimer.schedule(MyTimerTask(), 0, 1)
                }
            } else {
                enabled = false
                mainTimer.cancel()
                timeTracker = sdf.format(Date(0))
                timeValue.text = timeTracker
                container.removeAllViews()
            }

        }

        btnLap.setOnClickListener {
            if (enabled) {
                val viewLaps = layoutInflater.inflate(
                        R.layout.row, null, false
                )

                viewLaps.textContent.text = timeValue.text
                container.addView(viewLaps)
            }
        }



    }

    override fun onStop() {
        mainTimer.cancel()
        super.onStop()
    }
}
