package com.rcl.models.usermodel

data class UserData(
    val id: Int,
    val nickname: String,
    val avatar: String,
    val image: ImageURL,
    val last_online_at: String,
    val url: String,
    val name: String?,
    val sex: String?,
    val full_years: Int?,
    val last_online: String,
    val website: String,
    val location: String?,
    val banned: Boolean,
    val about: String,
    val about_html: String,
    val common_info: List<String>,
    val show_comments: Boolean,
    val in_friends: String?,
    val is_ignored: Boolean,
    val stats: Stats,
    val style_id: Int
)