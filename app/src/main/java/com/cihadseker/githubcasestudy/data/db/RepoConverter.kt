package com.cihadseker.githubcasestudy.data.db

import androidx.room.TypeConverter
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class RepoConverter {
    @TypeConverter
    fun fromString(value: String): Repo? {
        val type = object : TypeToken<Repo>() {}.type
        return Gson().fromJson<Repo>(value, type)
    }

    @TypeConverter
    fun fromModel(item: Repo?): String {
        val gson = Gson()
        return gson.toJson(item)
    }
}
