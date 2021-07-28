package com.renata.projeto_integrador.domain.usecase

import com.renata.projeto_integrador.data.model.MovieResponse
import com.renata.projeto_integrador.data.repository.MoviePopularRepository
import com.renata.projeto_integrador.domain.repository.MoviePopularRepositoryContract
import io.reactivex.Single

const val API_KEY = "893ae533a711d05e99a29d52a30419ed"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

//injeção de dependencias
class MoviePopularUseCase {

    val repository = MoviePopularRepository()

    fun getPopularMovies(): Single<MovieResponse> {
        return repository.getPopularMovies(API_KEY)
    }
}