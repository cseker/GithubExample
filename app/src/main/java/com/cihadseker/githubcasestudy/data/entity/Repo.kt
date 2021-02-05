package com.cihadseker.githubcasestudy.data.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Repo(
    @PrimaryKey val id: Int,
    @Embedded val owner: Owner,
    val name: String,
    val stargazers_count: Int,
    val open_issues_count: Int
) : Parcelable
