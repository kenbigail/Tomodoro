package com.pendekarsoftware.tomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.pendekarsoftware.tomodoro.databinding.ActivityTimer45Binding

class Timer45Activity : AppCompatActivity() {

    private var START_MILLI_SECONDS = 2700000L

    private lateinit var countdowntimer: CountDownTimer
    private lateinit var binding: ActivityTimer45Binding
    private var isRunning: Boolean = false
    private var timeInMilliSeconds = 2700000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer25)
        binding = ActivityTimer45Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivStart.setOnClickListener {
            if (isRunning) {
                pauseTimer()
            } else {
                startTimer(timeInMilliSeconds)
            }
        }

        binding.ivReset.setOnClickListener {
            resetTimer()
        }


    }

    private fun pauseTimer() {

        binding.ivStart.setImageResource(R.drawable.ivPause)
        countdowntimer.cancel()
        isRunning = false
        binding.ivReset.visibility = View.VISIBLE
    }

    private fun startTimer(time_in_seconds: Long) {
        countdowntimer = object : CountDownTimer(time_in_seconds, 1000) {

            override fun onTick(p0: Long) {
                timeInMilliSeconds = p0
                updateTextUI()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@Timer45Activity,
                    "Congrats! you have Finished the Timer.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        countdowntimer.start()

        isRunning = true
        binding.ivStart.setImageResource(R.drawable.ivPause)
        binding.ivReset.visibility = View.INVISIBLE

    }

    private fun resetTimer() {
        timeInMilliSeconds = START_MILLI_SECONDS
        updateTextUI()
        binding.ivReset.visibility = View.INVISIBLE
    }

    private fun updateTextUI() {
        val minute = (timeInMilliSeconds / 1000) / 60
        val seconds = (timeInMilliSeconds / 1000) % 60

        binding.textViewCountdown.text = "$minute:$seconds"
    }
}