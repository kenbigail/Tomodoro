package com.pendekarsoftware.tomodoro.article.data

import com.pendekarsoftware.tomodoro.R
import com.pendekarsoftware.tomodoro.article.model.ArtikelModel

object ArtikelData {
    private val title = arrayOf(
        "Apa Itu Teknik Pomodoro?",
        "Tips Menejemen Waktu",
        "Cara Mengatasi Ketergantungan Gadget",
        "Apa Manfaat Teknik Pomodoro?"

    )

    private val article = arrayOf(
        "Teknik Pomodoro adalah teknik pengaturan waktu yang telah diperkenalkan pada akhir tahun 1980 oleh Fransisco Cirillo.\n" +
                "\n" +
                "Teknik ini adalah teknik fokus dengan interval selang waktu. Melalui teknik ini kamu harus fokus dalam selang waktu tertentu, contohnya 25 menit. Setelah waktu habis, kamu diharuskan istirahat selama 5 menit. Cara ini dilakukan sebanyak 4 babak, setelah itu kamu bisa beristirahat lebih lama asal tidak lebih panjang daripada waktu untuk fokus.",
        "Tips memenejemen waktu kamu agar lebih produktif:\n" +
                "\n" +
                "1. Kuasai manajemen stres\n" +
                "2. Tingkatkan kemampuan berkomunikasi\n" +
                "3. Belajar untuk selalu fokus\n" +
                "4. Membuat perencanaan\n" +
                "5. Berani mengambilan keputusan\n" +
                "6. Mencari motivasi diri\n" +
                "7. Menyusun skala prioritas\n" +
                "8.Mulai memanfaatkan teknologi Time Management\n" +
                "9. Apresiasi kebiasaan baikmu",
        "1.  Batasi Penggunaan Gadget\n" +
                "2. Melakukan Aktivitas di Luar Rumah\n" +
                "3. Perbanyak Bersosialisasi\n" +
                "4. Ganti Gadget dengan Buku\n" +
                "5. Belajar Menyeimbangkan Waktu",
        "Manfaat Teknik Pomodoro"
    )

    val listData: ArrayList<ArtikelModel>
        get() {
            val list = arrayListOf<ArtikelModel>()
            for (position in title.indices) {
                val artikel = ArtikelModel()
                artikel.title = title[position]
                artikel.article = article[position]
                list.add(artikel)
            }
            return list
        }
}