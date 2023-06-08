package com.rcl.models.animemodel

data class AnimeListItem(
    val aired_on: String,
    val episodes: Int,
    val episodes_aired: Int,
    val id: Int,
    val image: Image,
    val kind: String,
    val name: String,
    val released_on: String,
    val russian: String,
    val score: String,
    val status: String,
    val url: String
)