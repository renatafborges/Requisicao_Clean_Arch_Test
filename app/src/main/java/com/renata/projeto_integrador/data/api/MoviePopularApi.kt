package com.renata.projeto_integrador.data.api

import com.renata.projeto_integrador.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviePopularApi {

    @GET("movie/popular")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Single<MovieResponse>
}