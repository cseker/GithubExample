package com.cihadseker.githubcasestudy.ui.main

import android.os.Bundle
import com.cihadseker.githubcasestudy.R
import com.cihadseker.githubcasestudy.base.ViewModelActivity
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.cihadseker.githubcasestudy.databinding.ActivityMainBinding
import com.cihadseker.githubcasestudy.ui.detail.DetailActivity

class MainActivity : ViewModelActivity() {

    private val viewModel: MainActivityViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding<ActivityMainBinding>(R.layout.activity_main).run {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
            adapter = MainAdapter(this@MainActivity, onRepoClicked)
        }
    }

    private val onRepoClicked: (repos: Repo) -> Unit = { repo ->
        DetailActivity.startActivity(this@MainActivity, repo)
    }
}