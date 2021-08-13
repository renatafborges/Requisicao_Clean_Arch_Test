package com.renata.projeto_integrador.allmovies.data.repository.database

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.renata.projeto_integrador.allmovies.data.model.Movie
import io.reactivex.Single

class MovieDataBase {
    private val movies = mutableListOf<Movie>()
    private val favoriteMovies = MutableLiveData<List<Movie>>(mutableListOf())

    fun getFavoriteMovies(): MutableLiveData<List<Movie>> {
        return favoriteMovies
    }

    fun getAllMovies(): Single<List<Movie>> {
        return Single.create { emitter ->
            emitter.onSuccess(movies)
        }
    }

    fun addMovie(movie: Movie) {
        Log.d("Quantidade filmes lista", movies.size.toString())
        val movieFinded = movies.find { it.id == movie.id }
        if (movieFinded == null) {
            movies.add(movie)
        }
    }

    fun findById(movie: Movie): Single<Movie> {
        val movieFinded = movies.find { it.id == movie.id }
        return Single.create { emitter ->
            if (movieFinded != null) {
                emitter.onSuccess(movieFinded)
            }
        }
    }

    fun updateMovie(movie: Movie) {
        val movieFinded = movies.find { it.id == movie.id }
        movies.remove(movieFinded)
        movies.add(movie)
        Log.d("movies", movies.size.toString())
        var favorites = movies.filter{
            it.isFavorite
        }
        favoriteMovies.value = favorites
    }
}