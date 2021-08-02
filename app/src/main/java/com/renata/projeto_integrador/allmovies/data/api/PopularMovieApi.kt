package com.renata.projeto_integrador.allmovies.data.api

import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface PopularMovieApi {

    @GET("movie/popular")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Single<MovieResponse>

}