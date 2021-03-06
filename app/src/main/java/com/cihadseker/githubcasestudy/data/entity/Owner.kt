package com.cihadseker.githubcasestudy.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(
    val login: String,
    val avatar_url: String
) : Parcelable