package com.pendekarsoftware.tomodoro.article.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtikelModel (
    var title: String = "",
    var article: String = ""
) : Parcelable
