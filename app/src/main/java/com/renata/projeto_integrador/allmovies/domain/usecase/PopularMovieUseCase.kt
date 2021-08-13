package com.renata.projeto_integrador.allmovies.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.data.repository.MoviePopularRepository
import io.reactivex.Single


const val API_KEY = "893ae533a711d05e99a29d52a30419ed"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

class PopularMovieUseCase {

    val repository = MoviePopularRepository()

    fun getPopularMovies(): Single<List<Movie>> {
        return repository.getPopularMovies(API_KEY)
    }

    fun getMovieDetails(movieId: Int): Single<Movie> {
        return repository.getMovieDetails(movieId,API_KEY)
    }

    fun getFavoritedMovies(): MutableLiveData<List<Movie>> {
        return repository.getFavoritedMovies()
    }

    fun update(movie: Movie) {
        repository.update(movie)
    }

}