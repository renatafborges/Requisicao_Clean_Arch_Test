package com.renata.projeto_integrador.moviedetails.data.api

import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Single<MovieDetails>
}
