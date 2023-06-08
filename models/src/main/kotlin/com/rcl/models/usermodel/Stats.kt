package com.rcl.models.usermodel

import com.rcl.models.usermodel.stats.FullStatuses
import com.rcl.models.usermodel.stats.Ratings
import com.rcl.models.usermodel.stats.Scores
import com.rcl.models.usermodel.stats.Statuses
import com.rcl.models.usermodel.stats.Types

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
