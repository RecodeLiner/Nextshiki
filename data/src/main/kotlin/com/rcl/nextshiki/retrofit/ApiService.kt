package com.rcl.nextshiki.retrofit

import com.rcl.nextshiki.retrofit.animemodel.AnimeList
import com.rcl.nextshiki.retrofit.usermodel.UserData
import com.rcl.nextshiki.retrofit.userrates.UserRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String, @Query("is_nickname") isNickname: String) : Response<UserData>
    @GET("v2/user_rates")
    suspend fun getListOf(@Query("user_id") userId: String, @Query("target_type") targetType: String ) : Response<UserRate>
    @GET("v2/user_rates")
    suspend fun getListOfWithStatus(@Query("user_id") userId: String, @Query("target_type") targetType: String, @Query("status") status: String ) : Response<UserRate>
    @GET("animes")
    suspend fun getAnime(@Query("page") page: Int, @Query("limit") limit: Int, @Query("order") order: String, @Query("kind") kind: String, @Query("status") status: String, @Query("score") score: Int, @Query("duration") duration: String, @Query("rating") rating: String, @Query("genre") genre: String, @Query("studio") studio: String, @Query("franchise") franchise: String, @Query("censored") censored: String, @Query("mylist") mylist: String, @Query("ids") ids: String, @Query("exclude_ids") exclude_ids: String, @Query("search") search: String) : Response<AnimeList>
}