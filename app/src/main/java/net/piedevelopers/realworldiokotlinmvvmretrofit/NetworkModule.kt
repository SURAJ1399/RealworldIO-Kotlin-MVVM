package net.piedevelopers.realworldiokotlinmvvmretrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import net.piedevelopers.api.RetrofitInterface
import net.piedevelopers.api.repo.ArticlesRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object  NetworkModule
{


    @Singleton
    @Provides
    fun providebaseurl():String{


        return  "https://conduit.productionready.io/api/"

      //function can be written like ->>  fun provide():String="https://jsonplaceholder.com";
    }


@Singleton
@Provides
fun provideretrofit(baseurl:String):Retrofit{

    val retrofit= Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
   return  retrofit

}

    @Singleton
    @Provides
    fun provideretrofitInterface(retrofit: Retrofit):RetrofitInterface{

        val api=retrofit.create(RetrofitInterface::class.java)

        return api

    }

//


}

