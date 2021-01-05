package net.piedevelopers.realworldiokotlinmvvmretrofit

import kotlinx.coroutines.runBlocking
import net.piedevelopers.api.repo.ArticlesRepo
import net.piedevelopers.api.repo.UsersRepo

import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class ExampleUnitTest {


    @Test
    fun getallarticles() {

        //execute command is required for testing purpose if interface method ic Call type
        //for suspend functions we run test inside runblocking method

        runBlocking {
            val articles = ArticlesRepo.getGlobalFeed()
            Assert.assertNotNull(articles.body()?.articles)
        }
    }
   


    @Test
    fun getsignupresponse() {

        //execute command is required for testing purpose if interface method ic Call type
        //for suspend functions we run test inside runblocking method

        runBlocking {
            val signupresp = UsersRepo.signup("ruesh123","ruesh123@gmail.com","ruesh@123")
            Assert.assertNotNull(signupresp.body())
        }

    }
    @Test
    fun getloginresponse() {

        //execute command is required for testing purpose if interface method ic Call type
        //for suspend functions we run test inside runblocking method

        runBlocking {
            val loginresp = UsersRepo.login("ruesh123@gmail.com","ruesh@123")
            Assert.assertNotNull(loginresp?.token)
        }


    }

    @Test
    fun updateuser()
    {
        runBlocking {
            val response=UsersRepo.updateUser("updated user","","","","")
            Assert.assertNotNull(response?.bio)
        }
    }



}