package net.piedevelopers.api

import net.piedevelopers.api.request.LoginRequest
import net.piedevelopers.api.request.SignupRequest
import net.piedevelopers.api.response.AllArticleResponse
import net.piedevelopers.api.response.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitInterface {

    @GET("articles")
   suspend fun getArticles(
    ): Response<AllArticleResponse>

    @POST("users")
    suspend fun signupUser(
            @Body userCreds: SignupRequest
    ): Response<UserResponse>

    @POST("users/login")
    suspend fun loginUser(
            @Body userCreds: LoginRequest
    ): Response<UserResponse>

}