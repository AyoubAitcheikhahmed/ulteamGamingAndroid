package com.banibegood.ulteam_gaming.domain

data class Game(
    val developer: String,
    val freetogameProfileUrl: String,
    val gameUrl: String,
    val genre: String,
    val id: Long,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)
