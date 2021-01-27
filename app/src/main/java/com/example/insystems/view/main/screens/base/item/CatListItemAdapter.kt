package com.example.insystems.view.main.screens.base.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.insystems.R
import com.example.insystems.model.repository.domain.Cat
import javax.inject.Inject
import javax.inject.Provider

class CatListItemAdapter @Inject constructor(
    private val presenterFactory: Provider<CatItemContract.Presenter>,
    val context: Context
) :
    ListAdapter<Cat, CatItemViewHolder>(CatDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_list_element, parent, false)
        return CatItemViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: CatItemViewHolder, position: Int) {
        val cat = getItem(position)
        holder.bind(cat)
        holder.bindPresenter(presenterFactory.get())
        holder.presenter.bindView(holder)
        holder.btnLike.setColorFilter(
            ContextCompat.getColor(context, if (cat.liked) R.color.pink else R.color.silver)
        )
        holder.btnLike.setOnClickListener {
            cat.liked = !cat.liked
            holder.presenter.setLike(cat)
        }
        holder.btnDownload.setOnClickListener {
            holder.presenter.downloadImage(cat)
        }
    }
}

object CatDiffCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(
        oldItem: Cat,
        newItem: Cat
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Cat,
        newItem: Cat
    ): Boolean {
        return oldItem.id == newItem.id
    }
}
