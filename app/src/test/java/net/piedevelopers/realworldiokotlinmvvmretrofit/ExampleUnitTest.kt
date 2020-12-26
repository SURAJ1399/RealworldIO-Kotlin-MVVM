package net.piedevelopers.realworldiokotlinmvvmretrofit

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.piedevelopers.api.RetrofitClient
import net.piedevelopers.api.repo.ArticlesRepo
import net.piedevelopers.api.response.AllArticleResponse
import org.junit.Assert
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val retrofitClient=RetrofitClient()
    @Test
     fun getallarticles() {

        //execute command is required for testing purpose if interface method ic Call type
        //for suspend functions we run test inside runblocking method

     runBlocking {
     val articles = ArticlesRepo.getGlobalFeed()
       Assert.assertNotNull(articles.body()?.articles)
}

    }
}