package com.renata.projeto_integrador.allmovies.data.repository.database

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.renata.projeto_integrador.allmovies.data.model.Movie
import io.reactivex.Single

class MovieDataBase {
    private val movies = mutableListOf<Movie>()
    private val favoriteMovies = MutableLiveData<List<Movie>>(mutableListOf())

    //buscar os filmes favoritados
    fun getFavoriteMovies(): MutableLiveData<List<Movie>> {
        return favoriteMovies
    }

    fun getAllMovies(): Single<List<Movie>> {
        return Single.create { emitter ->
            emitter.onSuccess(movies)
        }
    }


    //adicionar o filme
    fun addMovie(movie: Movie) {
        Log.d("Quantidade filmes lista", movies.size.toString())
        val movieFinded = movies.find { it.id == movie.id }
        if (movieFinded == null) {
            movies.add(movie)
        }
    }

    //buscar o filme por id e disponibilizar
    fun findById(movie: Movie): Single<Movie> {
        val movieFinded = movies.find { it.id == movie.id }
        return Single.create { emitter ->
            if (movieFinded != null) {
                emitter.onSuccess(movieFinded)
            }
        }
    }

    //atualizar o filme da lista (favoritado)
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