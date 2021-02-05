package com.cihadseker.githubcasestudy.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.cihadseker.githubcasestudy.base.BaseViewModel
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.cihadseker.githubcasestudy.repository.GithubRepository
import com.cihadseker.githubcasestudy.utils.CallResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : BaseViewModel() {

    val reposList = MutableLiveData<CallResult<List<Repo>>>()

    var username = ObservableField<String>()

    fun getRepositoryList() {
        username.get()?.let {
            launch {
                val result = withContext(Dispatchers.IO) { githubRepository.loadRepositoryList(it) }
                when (result) {
                    is CallResult.Success -> reposList.postValue(result)
                    is CallResult.Error -> reposList.postValue(null)
                }
            }
        }
    }
}
