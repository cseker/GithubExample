package com.cihadseker.githubcasestudy.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.cihadseker.githubcasestudy.extensions.bindResource
import com.cihadseker.githubcasestudy.extensions.loadImage
import com.cihadseker.githubcasestudy.ui.main.MainAdapter

@BindingAdapter("bind:imageUrl")
fun setImageUrl(view: ImageView, url: String) {
    view.loadImage(url)
}

@BindingAdapter("adapterMain")
fun bindMainRecyclerViewAdapter(view: RecyclerView, adapter: MainAdapter) {
    view.adapter = adapter
}

@BindingAdapter("adapterRepoList")
fun bindAdapterRepoList(view: RecyclerView, resource: CallResult<List<Repo>>?) {
    view.bindResource(resource) {
        val adapter = view.adapter as? MainAdapter
        adapter?.updateData(it)
    }
}