package com.pendekarsoftware.tomodoro

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.pendekarsoftware.tomodoro.databinding.ActivityTimerBinding
import java.util.*


class TimerActivity : AppCompatActivity() {
    private var mTextViewCountDown: TextView? = null
    private var mButtonStartPause: Button? = null
    private var mButtonReset: Button? = null
    private var mCountDownTimer: CountDownTimer? = null
    private var mTimerRunning = false
    private var mTimeLeftInMillis = START_TIME_IN_MILLIS
    private lateinit var binding: ActivityTimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTextViewCountDown = findViewById(R.id.text_view_countdown)
        binding.buttonStartPause.setOnClickListener {
            if (mTimerRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        }
        binding.buttonReset.setOnClickListener { resetTimer() }
        updateCountDownText()
    }

    private fun startTimer() {
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                mTimerRunning = false
                mButtonStartPause!!.text
                mButtonStartPause!!.visibility = View.INVISIBLE
                mButtonReset!!.visibility = View.VISIBLE
            }
        }.start()
        mTimerRunning = true
        mButtonStartPause!!.text = "Pause"
        mButtonReset!!.visibility = View.INVISIBLE
    }

    private fun pauseTimer() {
        mCountDownTimer!!.cancel()
        mTimerRunning = false
        mButtonStartPause!!.text = "Start"
        mButtonReset!!.visibility = View.VISIBLE
    }

    private fun resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS
        updateCountDownText()
        mButtonReset!!.visibility = View.INVISIBLE
        mButtonStartPause!!.visibility = View.VISIBLE
    }

    private fun updateCountDownText() {
        val minutes = (mTimeLeftInMillis / 1000).toInt() / 60
        val seconds = (mTimeLeftInMillis / 1000).toInt() % 60
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
        mTextViewCountDown!!.text = timeLeftFormatted
    }

    companion object {
        private const val START_TIME_IN_MILLIS: Long = 1500000
    }
}