package com.pendekarsoftware.tomodoro
import android.preference.PreferenceManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pendekarsoftware.tomodoro.UserPref.UserModel
import com.pendekarsoftware.tomodoro.UserPref.UserPreference
import com.pendekarsoftware.tomodoro.databinding.ActivityMoodboardBinding
import com.pendekarsoftware.tomodoro.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.main_color)
        }

        var btn_submit = findViewById<Button>(R.id.btn_login)
        btn_submit.setOnClickListener {
            callActivity()
        }
    }

    private fun callActivity() {
        val userPreference = UserPreference(this)
        val userModel = UserModel()

        userModel.isLogin = true
        userPreference.setUser(userModel)

        var et_user_name = findViewById<EditText>(R.id.et_username)
        var message = et_user_name.text.toString()

        val intent = Intent(this@UserActivity, MainActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE", message)
            startActivity(it)

            userModel.name = binding.etUsername.text.toString()
            userPreference.setUser(userModel)
        }
    }
}