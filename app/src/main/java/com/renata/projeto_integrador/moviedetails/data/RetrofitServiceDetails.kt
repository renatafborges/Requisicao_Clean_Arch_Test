package com.renata.projeto_integrador.moviedetails.data

import com.google.gson.GsonBuilder
import com.renata.projeto_integrador.moviedetails.data.api.MovieDetailsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"

class RetrofitServiceDetails {

    companion object {
        val SERVICE: MovieDetailsApi

        init {
            val gson = GsonBuilder().setLenient().create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            SERVICE = retrofit.create(MovieDetailsApi::class.java)
        }
    }
}