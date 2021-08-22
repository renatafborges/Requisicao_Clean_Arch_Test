package com.renata.projeto_integrador.allmovies.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.renata.projeto_integrador.allmovies.data.RetrofitService
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.data.repository.database.MovieDataBase
import io.reactivex.Single

class MoviePopularRepository {

    val movieDataBase = MovieDataBase()

    fun getPopularMovies(apiKey: String): Single<List<Movie>> {
        return RetrofitService.SERVICE.getPopularMovie(apiKey).flatMap { movieResponseList ->
            movieDataBase
                .getAllMovies()
                .map { favoriteMovieList ->
                    movieResponseList.results.forEach { movieItem ->
                        movieDataBase.addMovie(movieItem)
                    }
                    movieResponseList.results
                }
        }
    }

    fun getMovieDetails(movieId: Int, apiKey: String): Single<Movie> {
        return RetrofitService.SERVICE.getMovieDetail(movieId, apiKey)
    }

    fun getFavoritedMovies(): MutableLiveData<List<Movie>> {
        return movieDataBase.getFavoriteMovies()
    }

    fun update(movie: Movie){
        movieDataBase.updateMovie(movie)
    }
}

//TODO: entender melhor o funcionamento do map


