package com.pendekarsoftware.tomodoro.article.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pendekarsoftware.tomodoro.DetailArtikel
import com.pendekarsoftware.tomodoro.R
import com.pendekarsoftware.tomodoro.article.model.ArtikelModel

// 1.
class ArtikelAdapter
    // Menghubungkan Komponen Layout Dengan Kotlin
    (private val listArticle: ArrayList<ArtikelModel>) : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {

    // Menghubungkan Komponen Layout Dengan Kotlin
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Panggil imageview Pada File item_inspiration.xml pastebin.com/g21U041D
        var textView: TextView = itemView.findViewById(R.id.tv_title_article)
    }

    // Membuat Tampilan Di Recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Panggil Layout item_inspiration dan masukan ke variable view
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artikel, parent, false)
        // Kirim view/layout item_inspiration ke ViewHolder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // memanggil masing masing data dari parameter berdasarkan posisisnya
        val article = listArticle[position]

        //  tampilkan gambar ke imageview

        holder.textView.setText(article.title)
        // buat gambar agar bisa diklik
        holder.itemView.setOnClickListener { view ->
            val klikDetail = Intent(holder.itemView.context, DetailArtikel::class.java)
            klikDetail.putExtra(DetailArtikel.KUNCI_ARTIKEL, article)
            view.context.startActivity(klikDetail)
        }}
    // Menentukan Jumlah Data Di recyclerview

    override fun getItemCount(): Int {
        // Menampilkan Data Sebanyak Foto Yang Ada Di File InspirationData
        return listArticle.size}
    }
