package com.rcl.nextshiki.retrofit

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getUser(id: String, isNickname: Boolean) = apiService.getUser(id, if (isNickname) "1" else "0")
    suspend fun getListOf(userId: String, isAnime: Boolean) = apiService.getListOf(userId = userId, targetType = if (isAnime) "Anime" else "Manga")
    suspend fun getListOfWithStatus(userId: String, isAnime: Boolean, status: String) = apiService.getListOfWithStatus(userId = userId, targetType = if (isAnime) "Anime" else "Manga", status = status)
}