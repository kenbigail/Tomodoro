package com.pendekarsoftware.tomodoro
import android.preference.PreferenceManager
import android.content.Intent
import android.os.Bundle
import android.view.View
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