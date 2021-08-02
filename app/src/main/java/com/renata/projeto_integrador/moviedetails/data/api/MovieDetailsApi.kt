package com.renata.projeto_integrador.moviedetails.data.api

import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi {

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Single<MovieDetails>

    }
