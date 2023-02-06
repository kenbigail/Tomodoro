package com.pendekarsoftware.tomodoro.UserPref

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel (
    var name: String? = null,
    var isLogin: Boolean = false
) : Parcelable