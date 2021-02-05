package com.cihadseker.githubcasestudy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cihadseker.githubcasestudy.data.entity.Repo

@Database(
    entities = [(Repo::class)],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [(RepoConverter::class)])
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}
