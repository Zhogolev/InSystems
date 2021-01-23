package com.example.insystems.ui.main.screens.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.insystems.R
import com.example.insystems.data.network.model.Cat

class CatItemAdapter(private val onClick: (Cat) -> Unit) :
    ListAdapter<Cat, CatItemAdapter.CatItemViewHolder>(CatDiffCallback) {
    class CatItemViewHolder(itemView: View, val onClick: (Cat) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val catImageView: ImageView = itemView.findViewById(R.id.cat_image)
        private var currentCat: Cat? = null

        init {
            itemView.setOnClickListener {
                currentCat?.let {
                    onClick(it)
                }
            }

            val btnLike = itemView.findViewById<ImageButton>(R.id.btnLike)
            btnLike.setOnClickListener {
                /// todo implement
            }

            val btnDownload = itemView.findViewById<ImageButton>(R.id.btnDownload)
            btnDownload.setOnClickListener {
                /// todo implement
            }

        }

        fun bind(cat: Cat) {
            currentCat = cat
            cat.url.let {
                Glide.with(itemView).load(it)
                    .centerCrop()
                    .into(catImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cat_list_element, parent, false)
        return CatItemViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CatItemViewHolder, position: Int) {
        val cat = getItem(position)
        holder.bind(cat)
    }
}

object CatDiffCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return oldItem.id == newItem.id
    }
}
