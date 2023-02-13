package com.pendekarsoftware.tomodoro.Timer.timer25

import android.app.*
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.pendekarsoftware.tomodoro.R
import com.pendekarsoftware.tomodoro.databinding.ActivityTimer25Binding

class Timer25Activity : AppCompatActivity() {

    private var startMilliSeconds = 1500000L

    private lateinit var countdowntimer: CountDownTimer
    private lateinit var binding: ActivityTimer25Binding
    private var isRunning: Boolean = false
    private var timeInMilliSeconds = 1500000L

    val channelID = "channelID"
    private val channelName = "channelName"
    val notifID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer25)
        binding = ActivityTimer25Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        createNotifChannel()

        binding.ivStart.setOnClickListener {
            //ketika Tombol Start di Klik maka akan Run Timer
            if (isRunning) {
                //Deklarasi Function Pause Timer dan memunculkan Tombol Pause
                pauseTimer()
            } else {
                //Ketika Pause akan mendeklarasi Function startTimer
                startTimer(timeInMilliSeconds)
            }
        }

        binding.ivReset.setOnClickListener {
            //Ketika dipencet maka Timer akan Reset
            resetTimer()
        }
    }

    private fun createNotifChannel() {
        //Membuat Function createNotifChannel untuk memunculkan Notifikasi ketika Timer Selesai
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(channelID,channelName,NotificationManager.IMPORTANCE_DEFAULT).apply {
                //menambahkan Color Blue pada Lights
                lightColor= Color.BLUE
                enableLights(true)
            }
            // Val Notification Manager yang nantinya akan dipakai
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    private fun pauseTimer() {

        //Function pauseTimer
        binding.ivStart.setImageResource(R.drawable.iv_start)
        countdowntimer.cancel()
        isRunning = false
        binding.ivReset.visibility = View.VISIBLE
    }

    private fun startTimer(time_in_seconds: Long) {
        //membuat function Countdown Timer yang ketika berjalan akan berkurand setiap detik
        countdowntimer = object : CountDownTimer(time_in_seconds, 1000) {

            override fun onTick(p0: Long) {
                timeInMilliSeconds = p0
                updateTextUI()
            }

            override fun onFinish() {
                //ketika selesai akan menunjukkan Toast dan Notification untuk memperingati User.
                Toast.makeText(
                    this@Timer25Activity,
                    "Your timer is Finished. Good Job!", Toast.LENGTH_SHORT)
                    .show()

                val intent = Intent(this@Timer25Activity, Timer25Activity::class.java)
                val pendingIntent = TaskStackBuilder.create(this@Timer25Activity).run {
                    addNextIntentWithParentStack(intent)
                    getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
                }


                val notifManager = NotificationManagerCompat.from(this@Timer25Activity)

                val notif = NotificationCompat.Builder(this@Timer25Activity, channelID)
                    //Setup Resource dari Notifikasi
                    .setContentTitle("Timer Finished")
                    .setContentText("Good Job! you have finished your Timer.")
                    .setSmallIcon(R.drawable.ic_timer_notification)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .build()

                //Mendeklarasikan Notifikasi
                notifManager.notify(notifID, notif)
            }
        }
        //ketika Countdown Timer start maka akan merubah tombol menjadi pause
        countdowntimer.start()

        isRunning = true
        binding.ivStart.setImageResource(R.drawable.iv_pause)
        binding.ivReset.visibility = View.INVISIBLE

    }

    private fun resetTimer() {
        //Ketika reset timer maka akan Update UI dari Text
        timeInMilliSeconds = startMilliSeconds
        updateTextUI()
    }

    private fun updateTextUI() {
        //deklarasi fungsi UpdateTextUI yang membuat Timer muncul sesuai timeInMilliSeconds
        val minute = (timeInMilliSeconds / 1000) / 60
        val seconds = (timeInMilliSeconds / 1000) % 60

        binding.textViewCountdown.text = "$minute:$seconds"
    }

    //Membuat tombol back berfungsi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}