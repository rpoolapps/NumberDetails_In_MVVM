package com.ravisingh.numberdetails_in_mvvm.remote.retrofit

import com.ravisingh.numberdetails_in_mvvm.local.response.NumberResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


const val BASE_URL = "https://numberapi.com/"

interface NumberAPI {

    @GET("{number}")
    suspend fun getNumberFact(
        @Header("content-Type") str: String,
        @Path("number") number: Int
    ): Response<NumberResponse>


}