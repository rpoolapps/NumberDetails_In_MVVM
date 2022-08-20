package com.ravisingh.numberdetails_in_mvvm.local

import android.util.Log
import com.ravisingh.numberdetails_in_mvvm.local.response.NumberResponse
import com.ravisingh.numberdetails_in_mvvm.remote.retrofit.NumberAPI
import com.ravisingh.numberdetails_in_mvvm.util.Result
import com.ravisingh.numberdetails_in_mvvm.util.Status
import java.lang.Exception

class NumberRepo(private val numberAPI: NumberAPI) {

    suspend fun getNumberFact(number: Int): Result<NumberResponse> {
        return try {

            val response = numberAPI.getNumberFact("application/json", number)
            return Result(Status.SUCCESS, response.body(), null)

        } catch (e: Exception) {
            Log.d("TAG", "getNumberFact: ${e.message}")
            Result(Status.ERROR, null, null)
        }
    }
}