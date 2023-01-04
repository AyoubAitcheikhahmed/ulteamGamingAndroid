package com.banibegood.ulteam_gaming.domain

import com.squareup.moshi.Json

data class GamePicture(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)
