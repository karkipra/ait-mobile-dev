package com.pratikkarki.highlow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.pratikkarki.highlow.R.styleable.Snackbar
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_result.*
import java.util.*


class GameActivity : AppCompatActivity() {

    private var generatedNum = 0
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)




        generatedNum = savedInstanceState?.getInt("KEY_GEN") ?: generateNum() // if saved state does not exist then it will
        // create a new one

        game()

    }

    fun game() {
        btnGuess.setOnClickListener {


            if (!TextUtils.isEmpty(etGuess.text)) {
                var guess = etGuess.text.toString().toInt()
                count++

                tvStatus.text = when {
                    guess == generatedNum -> {

                        reset()

                        getString(R.string.win)



                    }
                    guess > generatedNum -> getString(R.string.higher)
                    else -> getString(R.string.lower)
                }
            } else {
                etGuess.error = getString(R.string.empty_et)
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState!!.putInt("KEY_GEN", generatedNum)
        super.onSaveInstanceState(outState)
    }

    public fun reset() {
        var intentResult = Intent()
        intentResult.setClass(GameActivity@ this,
                ResultActivity::class.java)
        startActivity(intentResult)

    }

    fun endText(): CharSequence? {
        return "You have made $count number of guesses"
    }

    private fun generateNum(): Int {
        return Random(System.currentTimeMillis()).nextInt(4)
    }
}
