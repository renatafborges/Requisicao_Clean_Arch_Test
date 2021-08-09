package com.renata.projeto_integrador.allmovies.data.repository

import android.util.Log
import com.renata.projeto_integrador.allmovies.data.RetrofitService
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
import com.renata.projeto_integrador.allmovies.data.repository.database.MovieDataBase
import io.reactivex.Single

class MoviePopularRepository {

    val movieDataBase = MovieDataBase()

    fun getPopularMovies(apiKey: String): Single<List<Movie>> {
        //map->pega um resultado e transforma em outro
        return RetrofitService.SERVICE.getPopularMovie(apiKey).flatMap { movieResponseList ->
            movieDataBase
                .getAllMovies()
                .map { favoriteMovieList ->
                    movieResponseList.results.forEach { movieResponse ->
                        movieDataBase.addMovie(movieResponse)
                    }
                    movieResponseList.results
                }
        }
    }

    fun getFavoritedMovies(): Single<List<Movie>> {
        return movieDataBase.getFavoriteMovies()
    }

    fun update(movie: Movie){
        Log.d("teste no repository", movie.toString())
        movieDataBase.updateMovie(movie)
    }


}

//TODO: entender melhor o funcionamento do map


