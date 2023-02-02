package com.pendekarsoftware.tomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pendekarsoftware.tomodoro.databinding.ActivityMainBinding
import com.pendekarsoftware.tomodoro.databinding.ActivityMoodboardBinding

class MoodboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityMoodboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoodboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val userPreference = UserPreference(this)
            val userModel = UserModel()

            startActivity(Intent(this, MainActivity::class.java))
            finish()

            // catat user udah login
            userModel.isLogin = true
            userPreference.setUser(userModel)

        }
    }
}

