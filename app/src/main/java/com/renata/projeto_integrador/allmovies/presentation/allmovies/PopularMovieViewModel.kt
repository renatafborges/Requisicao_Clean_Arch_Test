package com.renata.projeto_integrador.allmovies.presentation.allmovies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularMovieViewModel(): ViewModel() {

    val moviePopularUseCase = PopularMovieUseCase()
    val movieResult = MutableLiveData<List<Movie>>(mutableListOf())
    var movieFavoriteResult = MutableLiveData<List<Movie>>(mutableListOf())
    val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        moviePopularUseCase.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { movies ->
                    movieResult.value = movies
                },{
                        e -> error.value = e.message
                }
            )
    }

    fun getFavoritedMovies() {
        movieFavoriteResult = moviePopularUseCase.getFavoritedMovies()
    }

    fun update(movie: Movie){
        moviePopularUseCase.update(movie)
    }
}