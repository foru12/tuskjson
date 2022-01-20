package com.example.test6.Interface



import retrofit2.http.GET

interface RetrofitService {
    @GET("list.php")
    suspend fun getUrlList(): List<String>
}