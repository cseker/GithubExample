package com.cihadseker.githubcasestudy.extensions

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.cihadseker.githubcasestudy.utils.CallResult

inline fun <reified T : Any> View.bindResource(resource: CallResult<T>?, onSuccess: (T) -> Unit) {
    if (resource != null) {
        when (resource) {
            is CallResult.Success -> onSuccess(resource.data)
            is CallResult.Error -> Toast.makeText(context, "Hata", Toast.LENGTH_SHORT).show()
        }
    }
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .centerCrop()
        .into(this)
}