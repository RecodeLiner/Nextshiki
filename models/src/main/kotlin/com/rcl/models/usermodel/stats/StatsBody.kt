package com.rcl.models.usermodel.stats

data class StatsBody (
    val id: Int,
    val grouped_id: String,
    val name: String,
    val size: Int,
    val type: String
)