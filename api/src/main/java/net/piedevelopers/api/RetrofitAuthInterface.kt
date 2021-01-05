package net.piedevelopers.api

import net.piedevelopers.api.request.LoginRequest
import net.piedevelopers.api.request.SignupRequest
import net.piedevelopers.api.request.UpdateUserRequest
import net.piedevelopers.api.response.AllArticleResponse
import net.piedevelopers.api.response.User
import net.piedevelopers.api.response.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface RetrofitAuthInterface {

    @PUT("user")
   suspend fun updateuser(
            @Body userUpdateRequest: UpdateUserRequest
    ): Response<UserResponse>


    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

}