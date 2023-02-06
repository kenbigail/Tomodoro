package com.pendekarsoftware.tomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.pendekarsoftware.tomodoro.databinding.ActivityDetailArtikelBinding
import com.pendekarsoftware.tomodoro.R
import com.pendekarsoftware.tomodoro.article.model.ArtikelModel

class DetailArtikel : AppCompatActivity() {
    private lateinit var binding: ActivityDetailArtikelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val view = intent.getParcelableExtra<ArtikelModel>(KUNCI_ARTIKEL) as ArtikelModel
        initview(view)
    }

    private fun initview(view: ArtikelModel) {
        setSupportActionBar(binding.toolbar)
        binding.tvTitle.text = view.title
        binding.tvArticle.text = view.article

    }
    companion object {
        const val KUNCI_ARTIKEL = "dataartikel"
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}