package com.pendekarsoftware.tomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var  mUserPreference: UserPreference
    private lateinit var  userModel: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        mUserPreference = UserPreference(this)
        userModel = mUserPreference.getUser()



        Handler(Looper.getMainLooper()).postDelayed({
            //cek apakah user itu sudah pernah masuk aplikasi atau belum
            if (!userModel.isLogin) {
                //kalau user belum pernah login akan memainkan splash screen
                startActivity(Intent(this, SplashScreenActivity::class.java))
                finish()
            } else {
                //pindah ke Main Activity langsung ketika sudah login
                startActivity(Intent(this, MainActivity::class.java))
            }
        }, 3000)
    }
}