package net.piedevelopers.api.repo

import net.piedevelopers.api.RetrofitClient

object  ArticlesRepo {
     val retrofitClient=RetrofitClient()


    suspend fun getGlobalFeed()= retrofitClient.api.getArticles()
}