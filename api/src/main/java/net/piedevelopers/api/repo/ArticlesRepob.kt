package net.piedevelopers.api.repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import net.piedevelopers.api.RetrofitClient
import net.piedevelopers.api.RetrofitInterface
import net.piedevelopers.api.response.AllArticleResponse
import net.piedevelopers.api.response.Article
import retrofit2.Response
import javax.inject.Inject

class  ArticlesRepob
@Inject
constructor(
      val  retrofitInterface: RetrofitInterface
){


    suspend fun getGlobalFeed()= retrofitInterface.getArticles()
}