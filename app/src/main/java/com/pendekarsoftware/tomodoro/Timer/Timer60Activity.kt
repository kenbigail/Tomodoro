package com.pendekarsoftware.tomodoro.Timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.pendekarsoftware.tomodoro.R
import com.pendekarsoftware.tomodoro.databinding.ActivityTimer60Binding

class Timer60Activity : AppCompatActivity() {

    private var START_MILLI_SECONDS = 3600000L

    private lateinit var countdowntimer: CountDownTimer
    private lateinit var binding: ActivityTimer60Binding
    private var isRunning: Boolean = false
    private var timeInMilliSeconds = 3600000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer25)
        binding = ActivityTimer60Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

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

        binding.ivStart.setImageResource(R.drawable.iv_start)
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
                    this@Timer60Activity,
                    "Congrats! you have Finished the Timer.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        countdowntimer.start()

        isRunning = true
        binding.ivStart.setImageResource(R.drawable.iv_pause)
        binding.ivReset.visibility = View.INVISIBLE

    }

    private fun resetTimer() {
        timeInMilliSeconds = START_MILLI_SECONDS
        updateTextUI()
    }

    private fun updateTextUI() {
        val minute = (timeInMilliSeconds / 1000) / 60
        val seconds = (timeInMilliSeconds / 1000) % 60

        binding.textViewCountdown.text = "$minute:$seconds"
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}