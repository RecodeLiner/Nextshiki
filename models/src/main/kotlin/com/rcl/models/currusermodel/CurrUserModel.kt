package com.rcl.models.currusermodel

data class CurrUserModel(
    val avatar: String,
    val birth_on: Any,
    val full_years: Int,
    val id: Int,
    val image: Image,
    val last_online_at: String,
    val locale: String,
    val name: Any,
    val nickname: String,
    val sex: String,
    val url: String,
    val website: String
)