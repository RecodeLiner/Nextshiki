package com.rcl.nextshiki.retrofit

import com.rcl.models.animemodel.AnimeList
import com.rcl.models.currusermodel.CurrUserModel
import com.rcl.models.tokenmodel.TokenObject
import com.rcl.models.usermodel.UserData
import com.rcl.models.userrates.UserRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("api/users/whoami")
    suspend fun getCurrentUser(): Response<CurrUserModel>
    @GET("api/users/{id}")
    suspend fun getUser(@Path("id") id: String, @Query("is_nickname") isNickname: String) : Response<UserData>
    @POST("oauth/token")
    suspend fun getToken(@Query("grant_type") grantType: String, @Query("client_id") clientId: String, @Query("client_secret") clientSecret: String, @Query("code") code: String, @Query("redirect_uri") redirectUri: String): Response<TokenObject>
    @POST("oauth/token")
    suspend fun upgradeToken(@Query("grant_type") grantType: String, @Query("client_id") clientId: String, @Query("client_secret") clientSecret: String, @Query("refresh_token") refresh_token: String): Response<TokenObject>
    @GET("api/v2/user_rates")
    suspend fun getListOf(@Query("user_id") userId: String, @Query("target_type") targetType: String ) : Response<UserRate>
    @GET("api/v2/user_rates")
    suspend fun getListOfWithStatus(@Query("user_id") userId: String, @Query("target_type") targetType: String, @Query("status") status: String ) : Response<UserRate>
    @GET("api/animes")
    suspend fun getAnime(@Query("page") page: Int, @Query("limit") limit: Int, @Query("order") order: String, @Query("kind") kind: String, @Query("status") status: String, @Query("score") score: Int, @Query("duration") duration: String, @Query("rating") rating: String, @Query("genre") genre: String, @Query("studio") studio: String, @Query("franchise") franchise: String, @Query("censored") censored: String, @Query("mylist") mylist: String, @Query("ids") ids: String, @Query("exclude_ids") exclude_ids: String, @Query("search") search: String) : Response<AnimeList>
}