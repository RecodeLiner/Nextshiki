package com.rcl.nextshiki.retrofit

import com.rcl.data.BuildConfig
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getCurrentUser() = apiService.getCurrentUser()
    fun setToken(token: String) {RetrofitInstance.token = token}
    suspend fun getUser(id: String, isNickname: Boolean) = apiService.getUser(id, if (isNickname) "1" else "0")
    suspend fun getToken(code: String) = apiService.getToken(grantType = "authorization_code", clientId = BuildConfig.CLIENT_ID, clientSecret = BuildConfig.CLIENT_SECRET, code = code, redirectUri = "urn:ietf:wg:oauth:2.0:oob")
    suspend fun upgradeToken(refreshToken: String) = apiService.upgradeToken(grantType = "refresh_token", clientId = BuildConfig.CLIENT_ID, clientSecret = BuildConfig.CLIENT_SECRET, refresh_token = refreshToken)
    suspend fun getListOf(userId: String, isAnime: Boolean) = apiService.getListOf(userId = userId, targetType = if (isAnime) "Anime" else "Manga")
    suspend fun getListOfWithStatus(userId: String, isAnime: Boolean, status: String) = apiService.getListOfWithStatus(userId = userId, targetType = if (isAnime) "Anime" else "Manga", status = status)
}