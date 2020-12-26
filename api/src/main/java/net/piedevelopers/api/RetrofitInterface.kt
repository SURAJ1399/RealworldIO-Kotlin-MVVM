package net.piedevelopers.api

import net.piedevelopers.api.response.AllArticleResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("articles")
   suspend fun getArticles(
    ): Response<AllArticleResponse>
}