package com.pendekarsoftware.tomodoro

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pendekarsoftware.tomodoro.article.adapter.ArtikelAdapter
import com.pendekarsoftware.tomodoro.article.data.ArtikelData
import com.pendekarsoftware.tomodoro.article.model.ArtikelModel
import com.pendekarsoftware.tomodoro.databinding.ActivityMainBinding
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
    }