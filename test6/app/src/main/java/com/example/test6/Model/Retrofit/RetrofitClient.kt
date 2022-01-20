package com.example.test6.model.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var retrofit: Retrofit? = null
    fun  getClient(baseUrl: String): Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient : OkHttpClient = OkHttpClient.Builder()
            .readTimeout((60*2).toLong(),TimeUnit.SECONDS)
            .connectTimeout((60*2).toLong(),TimeUnit.SECONDS)
            .writeTimeout((60*2).toLong(),TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
        return  retrofit!!

    }
}