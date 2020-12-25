package net.piedevelopers.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val BaseUrl="https://conduit.productionready.io/api/"
    val retrofit= Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api=retrofit.create(RetrofitInterface::class.java)


}