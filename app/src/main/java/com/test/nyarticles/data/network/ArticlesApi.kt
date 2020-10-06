package com.test.nyarticles.data.network

import com.test.nyarticles.data.model.Articles
import com.test.nyarticles.data.model.Result
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface ArticlesApi {

    @GET("1.json?api-key=F01FO0igKnynBDn8Zv7d0nSoH2fDc7ep")
    suspend fun getArticles() : Response<Articles>

    companion object{
        operator fun invoke(
            interceptor: NetworkConnectionInterceptor
        ) :ArticlesApi{

            val okkHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpClient)
                .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/viewed/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ArticlesApi::class.java)
        }
    }
}