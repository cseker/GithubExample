package com.cihadseker.githubcasestudy.di.module

import com.cihadseker.githubcasestudy.base.ViewModelActivity
import com.cihadseker.githubcasestudy.base.ViewModelFragment
import com.cihadseker.githubcasestudy.di.scope.ActivityScope
import com.cihadseker.githubcasestudy.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BaseModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeViewModelFragment(): ViewModelFragment
}
