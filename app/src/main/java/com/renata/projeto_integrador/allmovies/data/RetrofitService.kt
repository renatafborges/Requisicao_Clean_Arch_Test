package com.renata.projeto_integrador.allmovies.data

import com.google.gson.GsonBuilder
import com.renata.projeto_integrador.allmovies.data.api.PopularMovieApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.themoviedb.org/3/"

class RetrofitService {

    companion object {
        val SERVICE: PopularMovieApi

        init {
            val gson = GsonBuilder().setLenient().create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            SERVICE = retrofit.create(PopularMovieApi::class.java)
        }
    }
}