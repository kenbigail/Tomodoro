package com.pendekarsoftware.tomodoro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pendekarsoftware.tomodoro.Article.adapter.ArtikelAdapter
import com.pendekarsoftware.tomodoro.Article.data.ArtikelData
import com.pendekarsoftware.tomodoro.Article.model.ArtikelModel
import com.pendekarsoftware.tomodoro.Timer.timer25.Timer25Activity
import com.pendekarsoftware.tomodoro.Timer.timer45.Timer45Activity
import com.pendekarsoftware.tomodoro.Timer.timer60.Timer60Activity
import com.pendekarsoftware.tomodoro.UserPref.UserModel
import com.pendekarsoftware.tomodoro.UserPref.UserPreference
import com.pendekarsoftware.tomodoro.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    // Deklarasi Variable Koneksi Komponen xml Ke File Kotlin
    private lateinit var binding: ActivityMainBinding
    private lateinit var  mUserPreference: UserPreference
    private lateinit var  userModel: UserModel

    // Perintah Dalama OnCreate Akan Dijalankan Ketika Activity Pertama Dibuka
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Variable Binding Dengan layoutInflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_main)

        initUsername()
        initRecyclerViewArticle()
        initNavMenu()
        initQuote()
    }
    private fun initUsername() {
        // Mengambil Text Dari UserPreference
        mUserPreference = UserPreference(this)
        userModel = mUserPreference.getUser()

        binding.tvName.text = userModel.name
    }

    private fun initRecyclerViewArticle() {
        // Buat Variable Penampung Kumpulan Data
        val list: ArrayList<ArtikelModel> = arrayListOf()
        // Tambahkan Data Ke Dalam List Dari inspirationData
        list.addAll(ArtikelData.listData)

        // Panggil adapter Dan Masukkan list Kedalamnya
        val inspirationAdapter = ArtikelAdapter (list)

        // Pengaturan RecyclerView
        binding.rvArtikel.setHasFixedSize(true)
        binding.rvArtikel.layoutManager = LinearLayoutManager(this)
        // Pasang Adapter Ke RecyclerView
        binding.rvArtikel.adapter = inspirationAdapter
    }
    private fun initNavMenu() {
        // Memberikan Aksi Klik Pada Icon
        binding.timer25.setOnClickListener {
            // Memulai Aktivitas Baru
            // Memberikan Intent Untuk Menunjukan Tujuan Pergi
            startActivity(Intent(this@MainActivity, Timer25Activity::class.java))
        }
        binding.timer45.setOnClickListener {
            startActivity(Intent(this@MainActivity, Timer45Activity::class.java))
        }
        binding.timer60.setOnClickListener {
            startActivity(Intent(this@MainActivity, Timer60Activity::class.java))
        }
    }
    private fun initQuote() {
        // Mengambil Waktu Sekarang.
        val timeNow = Calendar.getInstance()

        // Menentukan Format Jam "HH" (Hour 2 Digit).
        val timeFormat = SimpleDateFormat("HH")

        // Membentuk Waktu Sekarang Hanya Jam Saja.
        val time = timeFormat.format(timeNow.time)

        // Menentukan Quotes berdasarkan Jam (Data Dari Variable Time)
        when {
            // Jam 00-04 Quotes Pertama
            time.toInt() in 0..4 -> {
                // Ganti Gambar Jadi Malam
                binding.tvQuote.setText(R.string.quote1)
                binding.tvQuoteWriter.setText(R.string.writer1)
            }
            // Jam 04-06 Quotes Kedua
            time.toInt() in 4..6 -> {
                binding.tvQuote.setText(R.string.quote2)
                binding.tvQuoteWriter.setText(R.string.writer2)
            }
            // Jam 06-09 Quotes Ketiga
            time.toInt() in 6..9 -> {
                binding.tvQuote.setText(R.string.quote3)
                binding.tvQuoteWriter.setText(R.string.writer3)
            }
            // Jam 09-12 Quotes Keempat
            time.toInt() in 9..12 -> {
                binding.tvQuote.setText(R.string.quote4)
                binding.tvQuoteWriter.setText(R.string.writer4)
            }
            // Jam Jam 12-16 Quotes Kelima
            time.toInt() in 12..16 -> {
                binding.tvQuote.setText(R.string.quote5)
                binding.tvQuoteWriter.setText(R.string.writer5)
            }
            // Jam 16-18 Quotes Keenam
            time.toInt() in 16..18 -> {
                binding.tvQuote.setText(R.string.quote6)
                binding.tvQuoteWriter.setText(R.string.writer6)
            }
            // Jam 18-23 Quotes Ketujuh
            time.toInt() in 18..23 -> {
                binding.tvQuote.setText(R.string.quote7)
                binding.tvQuoteWriter.setText(R.string.writer7)
            }
            }
        }
    }