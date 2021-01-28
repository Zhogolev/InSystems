package com.example.insystems.model.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatDto(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)