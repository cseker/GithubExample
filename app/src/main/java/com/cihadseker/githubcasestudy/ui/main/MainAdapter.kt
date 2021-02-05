package com.cihadseker.githubcasestudy.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.cihadseker.githubcasestudy.R
import com.cihadseker.githubcasestudy.data.entity.Repo
import com.cihadseker.githubcasestudy.databinding.RepoItemsBinding

class MainAdapter(private val context: Context, private val onRepoClicked: (repos: Repo) -> Unit) :
    RecyclerView.Adapter<MainAdapter.RepoViewHolder>() {

    private var repoList: List<Repo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {

        val binding: RepoItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.repo_items,
            parent,
            false
        )
        val holder = RepoViewHolder(binding)

        holder.itemView.setOnClickListener {
            if (holder.adapterPosition != RecyclerView.NO_POSITION)
                onRepoClicked.invoke(repoList[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int = repoList.size

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        if (position != RecyclerView.NO_POSITION)
            holder.bind(repoList[position])
    }

    fun updateData(newRepoList: List<Repo>) {
        repoList = newRepoList
        notifyDataSetChanged()
    }

    class RepoViewHolder(private val binding: RepoItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repo) {
            binding.setVariable(BR.repo, repo)
            binding.executePendingBindings()
        }
    }
}