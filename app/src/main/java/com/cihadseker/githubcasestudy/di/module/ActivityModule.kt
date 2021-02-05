package com.cihadseker.githubcasestudy.di.module

import com.cihadseker.githubcasestudy.di.scope.ActivityScope
import com.cihadseker.githubcasestudy.ui.detail.DetailActivity
import com.cihadseker.githubcasestudy.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector()
    internal abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector()
    internal abstract fun contributeDetailActivity(): DetailActivity
}
