package com.example.insystems.view.main.screens.base.item

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.insystems.R
import com.example.insystems.model.repository.domain.Cat

class CatItemViewHolder(itemView: View, private val context: Context) :
    RecyclerView.ViewHolder(itemView), CatItemContract.View {

    lateinit var presenter: CatItemContract.Presenter
    private val catImageView: ImageView = itemView.findViewById(R.id.cat_image)
    override lateinit var currentCat: Cat

    val btnLike: AppCompatImageButton = itemView.findViewById(R.id.btnLike)
    val btnDownload: AppCompatImageButton = itemView.findViewById(R.id.btnDownload)

    fun bindPresenter(presenter: CatItemContract.Presenter) {
        this.presenter = presenter
    }

    fun bind(cat: Cat) {
        currentCat = cat
        cat.image.let {
            try {
                Glide.with(itemView)
                    .load(it)
                    .centerCrop()
                    .into(catImageView)
            } catch (e: Throwable) {
                print("cant load image for cat: ${cat.id}")
            }
        }
    }

    private fun toggleLikeButtonColor(isLiked: Boolean) {
        btnLike.setColorFilter(
            ContextCompat.getColor(
                context,
                if (isLiked) R.color.pink else R.color.silver
            )
        )
    }


    override fun showInFavorites() {
        toggleLikeButtonColor(true)
    }

    override fun showNotInFavorites() {
        toggleLikeButtonColor(false)
    }

}
