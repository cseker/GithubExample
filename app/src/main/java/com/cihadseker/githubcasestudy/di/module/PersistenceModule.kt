package com.cihadseker.githubcasestudy.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.cihadseker.githubcasestudy.data.db.AppDatabase
import com.cihadseker.githubcasestudy.data.db.RepoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "GithubRepo.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideRepoDao(@NonNull database: AppDatabase): RepoDao {
        return database.repoDao()
    }
}
