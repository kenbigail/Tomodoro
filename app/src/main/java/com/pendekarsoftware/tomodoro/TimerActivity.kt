package com.pendekarsoftware.tomodoro

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pendekarsoftware.tomodoro.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {

    private var START_MILLI_SECONDS = 1500000L

    private lateinit var countdowntimer: CountDownTimer
    private lateinit var binding: ActivityTimerBinding
    private var isRunning: Boolean = false
    private var timeInMilliSeconds = 1500000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)


        binding.button.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            } else {
                startTimer(timeInMilliSeconds)
            }
        }

        binding.buttonReset.setOnClickListener {
            resetTimer()
        }


    }

    private fun pauseTimer() {

        binding.button.text = "Start"
        countdowntimer.cancel()
        isRunning = false
        binding.buttonReset.visibility = View.VISIBLE
    }

    private fun startTimer(time_in_seconds: Long) {
        countdowntimer = object : CountDownTimer(time_in_seconds, 1000) {

            override fun onTick(p0: Long) {
                timeInMilliSeconds = p0
                updateTextUI()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@TimerActivity,
                    "Congrats! you have Finished the Timer.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        countdowntimer.start()

        isRunning = true
        binding.button.text = "Pause"
        binding.buttonReset.visibility = View.INVISIBLE

    }

    private fun resetTimer() {
        timeInMilliSeconds = START_MILLI_SECONDS
        updateTextUI()
        binding.buttonReset.visibility = View.INVISIBLE
    }

    private fun updateTextUI() {
        val minute = (timeInMilliSeconds / 1000) / 60
        val seconds = (timeInMilliSeconds / 1000) % 60

        binding.textViewCountdown.text = "$minute:$seconds"
    }
}