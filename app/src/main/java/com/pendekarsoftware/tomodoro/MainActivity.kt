package com.pendekarsoftware.tomodoro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pendekarsoftware.tomodoro.UserPref.UserModel
import com.pendekarsoftware.tomodoro.UserPref.UserPreference
import com.pendekarsoftware.tomodoro.article.adapter.ArtikelAdapter
import com.pendekarsoftware.tomodoro.article.data.ArtikelData
import com.pendekarsoftware.tomodoro.article.model.ArtikelModel
import com.pendekarsoftware.tomodoro.databinding.ActivityMainBinding
import com.pendekarsoftware.tomodoro.TimerActivity
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    // Deklarasi Variable Keneksi Komponen xml Ke File Kotlin
    private lateinit var binding: ActivityMainBinding

    // Perintah Dalama OnCreate Akan Dijalankan Ketika Activity Pertama Dibuka
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Variable Binding Dengan layoutInflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_main)

        initRecyclerViewArticle()
        initNavMenu()
        initQuote()
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
            startActivity(Intent(this@MainActivity, TimerActivity::class.java))
        }
        binding.timer45.setOnClickListener {
            startActivity(Intent(this@MainActivity, TimerActivity::class.java))
        }
        binding.timer60.setOnClickListener {
            startActivity(Intent(this@MainActivity, TimerActivity::class.java))
        }
    }
    private fun initQuote() {
        // Mengambil Waktu Sekarang.
        val timeNow = Calendar.getInstance()

        // Menentukan Format Jam "HH" (Hour 2 Digit).
        val timeFormat = SimpleDateFormat("HH")

        // Membentuk Waktu Sekarang Hanya Jam Saja.
        val time = timeFormat.format(timeNow.time)

        // Menentukan Gambar Berdasarkan Jam Sekarang (Data Dari Variable Time)
        when {
            // Jam 00-06 Gambar Malam
            time.toInt() in 1..6 -> {
                // Ganti Gambar Jadi Malam
                binding.tvQuote.setText(R.string.quote1)
                binding.tvQuoteWriter.setText(R.string.writer1)
            }
            // Jam 07-12 Gambar Pagi
            time.toInt() in 7..12 -> {
                binding.tvQuote.setText(R.string.quote2)
                binding.tvQuoteWriter.setText(R.string.writer2)
            }
            }
        }
    }