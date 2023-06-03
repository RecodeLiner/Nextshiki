package com.rcl.nextshiki.retrofit.userrates

data class UserRateItem(
    val chapters: Int,
    val created_at: String,
    val episodes: Int,
    val id: Int,
    val rewatches: Int,
    val score: Int,
    val status: String,
    val target_id: Int,
    val target_type: String,
    val text: String,
    val text_html: String,
    val updated_at: String,
    val user_id: Int,
    val volumes: Int
)