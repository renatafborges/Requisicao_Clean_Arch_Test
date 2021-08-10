package com.renata.projeto_integrador.moviedetails.domain

import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
import com.renata.projeto_integrador.moviedetails.data.repository.MovieDetailsRepository
import io.reactivex.Single

const val API_KEY = "893ae533a711d05e99a29d52a30419ed"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

class MovieDetailsUseCase {

    val repository = MovieDetailsRepository()

    fun getMovieDetails(movieId: Int): Single<MovieDetails> {
        return repository.getMovieDetails(movieId, API_KEY)
    }
}