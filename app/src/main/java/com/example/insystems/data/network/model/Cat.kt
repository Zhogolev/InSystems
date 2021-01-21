package com.example.insystems.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cat(
    val height: Int,
    val id: String,
    val url: String,
    val width: Int
)