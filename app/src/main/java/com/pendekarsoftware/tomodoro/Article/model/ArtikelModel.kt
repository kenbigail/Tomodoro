package com.pendekarsoftware.tomodoro.Article.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtikelModel (
    var title: String = "",
    var article: String = ""
) : Parcelable
