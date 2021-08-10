package com.renata.projeto_integrador.moviedetails.data.repository

import com.renata.projeto_integrador.moviedetails.data.RetrofitServiceDetails
import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
import io.reactivex.Single

class MovieDetailsRepository {

    fun getMovieDetails(movieId: Int, apiKey: String): Single<MovieDetails> {
        return RetrofitServiceDetails.SERVICE.getMovieDetail(movieId, apiKey)
    }
}
