package com.cihadseker.githubcasestudy.data.api

import com.cihadseker.githubcasestudy.data.entity.Repo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{user}/repos")
    fun fetchRepos(@Path("user") username: String): Deferred<List<Repo>>
}
