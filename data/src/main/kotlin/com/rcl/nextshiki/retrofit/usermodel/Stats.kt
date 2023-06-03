package com.rcl.nextshiki.retrofit.usermodel

import com.rcl.nextshiki.retrofit.usermodel.stats.FullStatuses
import com.rcl.nextshiki.retrofit.usermodel.stats.Ratings
import com.rcl.nextshiki.retrofit.usermodel.stats.Scores
import com.rcl.nextshiki.retrofit.usermodel.stats.Statuses
import com.rcl.nextshiki.retrofit.usermodel.stats.Types

data class Stats(
    val statuses: Statuses,
    val full_statuses: FullStatuses,
    val scores: Scores,
    val types: Types,
    val ratings: Ratings,
    val has_anime : Boolean,
    val has_manga : Boolean,
    val genres: List<String>?,
    val studios: List<String>?,
    val publishers: List<String>?,
)
