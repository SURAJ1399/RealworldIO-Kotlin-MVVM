package net.piedevelopers.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    var authToken: String? = null

    private val authInterceptor = Interceptor { chain ->
        var req = chain.request()
        authToken?.let {
            req = req.newBuilder()
                    .header("Authorization", "Token $it")
                    .build()
        }
        chain.proceed(req)
    }

    val okHttpBuilder = OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(2, TimeUnit.SECONDS)




    val BaseUrl="https://conduit.productionready.io/api/"

    val retrofit= Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitauth= Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(okHttpBuilder.addInterceptor(authInterceptor).build())

            .addConverterFactory(GsonConverterFactory.create())
            .build()



    val api=retrofit.create(RetrofitInterface::class.java)
    val authapi=retrofitauth.create(RetrofitAuthInterface::class.java)


}