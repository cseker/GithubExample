package com.cihadseker.githubcasestudy

import com.cihadseker.githubcasestudy.di.DaggerAppComponent
import dagger.android.DaggerApplication

@Suppress("unused")
class GithubApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.factory().create(this)

    override fun applicationInjector() = appComponent
}
