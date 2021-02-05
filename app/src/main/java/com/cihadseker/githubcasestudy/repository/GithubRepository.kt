package com.cihadseker.githubcasestudy.repository

import com.cihadseker.githubcasestudy.data.api.GithubApi
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.cihadseker.githubcasestudy.utils.CallResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository @Inject constructor(private val githubService: GithubApi) : Repository {

    suspend fun loadRepositoryList(repoName: String): CallResult<List<Repo>> {
        return try {
            val result = githubService.fetchRepos(username = repoName).await()
            CallResult.Success(result)
        } catch (ex: Exception) {
            CallResult.Error(ex)
        }
    }
}