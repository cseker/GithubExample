package com.cihadseker.githubcasestudy.data.db

import androidx.room.*
import com.cihadseker.githubcasestudy.data.entity.Repo

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(repo: Repo)

    @Update
    fun updateRepo(repo: Repo)

    @Query("SELECT * FROM Repo WHERE id = :id_")
    fun getRepo(id_: Int): Repo
}
