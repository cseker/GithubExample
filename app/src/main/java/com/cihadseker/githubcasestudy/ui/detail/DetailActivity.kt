package com.cihadseker.githubcasestudy.ui.detail

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.cihadseker.githubcasestudy.R
import com.cihadseker.githubcasestudy.base.ViewModelActivity
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.cihadseker.githubcasestudy.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : ViewModelActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding<ActivityDetailBinding>(R.layout.activity_detail).run {
            lifecycleOwner = this@DetailActivity
            repo = getRepoFromIntent()
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getRepoFromIntent() = intent.getParcelableExtra(REPO_EXTRA) as Repo

    companion object {

        const val REPO_EXTRA = "repo_extra"

        fun startActivity(context: Context?, repo: Repo) {
            if (context is Activity) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(REPO_EXTRA, repo)
                context.startActivity(intent)
            }
        }
    }
}
