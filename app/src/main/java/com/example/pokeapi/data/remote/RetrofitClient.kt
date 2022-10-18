package com.example.pokeapi.data.remote

import com.example.pokeapi.data.remote.apiservices.PokeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun provideOkHttpClient() =
        OkHttpClient().newBuilder().addInterceptor(provideLoggingInterceptor())
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()

    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun providePokeApi(): PokeApi = retrofit.create(PokeApi::class.java)
}