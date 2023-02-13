package com.pendekarsoftware.tomodoro

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pendekarsoftware.tomodoro.Timer.Timer25Activity
import com.pendekarsoftware.tomodoro.Timer.Timer45Activity
import com.pendekarsoftware.tomodoro.Timer.Timer60Activity
import com.pendekarsoftware.tomodoro.article.adapter.ArtikelAdapter
import com.pendekarsoftware.tomodoro.article.data.ArtikelData
import com.pendekarsoftware.tomodoro.article.model.ArtikelModel
import com.pendekarsoftware.tomodoro.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    // Deklarasi Variable Keneksi Komponen xml Ke File Kotlin
    private lateinit var binding: com.pendekarsoftware.tomodoro.databinding.ActivityMainBinding

    // Perintah Dalama OnCreate Akan Dijalankan Ketika Activity Pertama Dibuka
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Variable Binding Dengan layoutInflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_main)

        initName()
        initRecyclerViewArticle()
        initNavMenu()
        initQuote()
    }

    private fun initName() {
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        val textview = findViewById<TextView>(R.id.tv_name).apply {
            text = message
        }
    }

    private fun initRecyclerViewArticle() {
        // Buat Variable Penampung Kumpulan Data
        val list: ArrayList<ArtikelModel> = arrayListOf()
        // Tambahkan Data Ke Dalam List Dari inspirationData
        list.addAll(ArtikelData.listData)

        // Panggil adapter Dan Masukkan list Kedalamnya
        val inspirationAdapter = ArtikelAdapter(list)

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
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote1)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer1)
            }
            // Jam 04-06 Quotes Kedua
            time.toInt() in 4..6 -> {
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote2)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer2)
            }
            // Jam 06-09 Quotes Ketiga
            time.toInt() in 6..9 -> {
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote3)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer5)
            }
            // Jam 09-12 Quotes Keempat
            time.toInt() in 9..12 -> {
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote4)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer5)
            }
            // Jam Jam 12-16 Quotes Kelima
            time.toInt() in 12..16 -> {
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote5)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer5)
            }
            // Jam 16-18 Quotes Keenam
            time.toInt() in 16..18 -> {
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote6)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer6)
            }
            // Jam 18-23 Quotes Ketujuh
            time.toInt() in 18..23 -> {
                binding.tvQuote.setText(com.pendekarsoftware.tomodoro.R.string.quote7)
                binding.tvQuoteWriter.setText(com.pendekarsoftware.tomodoro.R.string.writer7)
            }
        }
    }
}