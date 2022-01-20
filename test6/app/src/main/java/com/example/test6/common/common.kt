package com.example.test6.common

import com.example.test6.Interface.RetrofitService
import com.example.test6.model.retrofit.RetrofitClient


object common {
    //private val  BASE_URl = "https://dev-tasks.alef.im"
    object Common {
        private const val  BASE_URl = "https://dev-tasks.alef.im/task-m-001/"

        val  retrofitService : RetrofitService
            get() = RetrofitClient
                .getClient(BASE_URl)
                .create(RetrofitService::class.java)
    }
}