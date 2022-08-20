package com.ravisingh.numberdetails_in_mvvm.hilt

import com.ravisingh.numberdetails_in_mvvm.local.NumberRepo
import com.ravisingh.numberdetails_in_mvvm.remote.retrofit.BASE_URL
import com.ravisingh.numberdetails_in_mvvm.remote.retrofit.NumberAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NumberModule {

    @Provides
    @Singleton
    fun provideRetrofitInterface(): NumberAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(NumberAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepo(numberAPI: NumberAPI): NumberRepo {
        return NumberRepo(numberAPI)
    }


}