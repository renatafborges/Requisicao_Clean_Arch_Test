package com.renata.projeto_integrador.allmovies.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class PopularMovieViewModel(): ViewModel() {

    val moviePopularUseCase = PopularMovieUseCase()
    val movieResult = MutableLiveData<List<Movie>>(mutableListOf())
    val movieFavoriteResult = MutableLiveData<List<Movie>>(mutableListOf())
    val error: MutableLiveData<String> = MutableLiveData()

    fun getPopularMovies() {
        moviePopularUseCase.getPopularMovies()
            .subscribeOn(Schedulers.io()) //define em qual thread vai fazer requisição
            .observeOn(AndroidSchedulers.mainThread()) //para onde vai enviar
            .subscribe( //vai ter o objeto de resposta
                { movies ->
                    movieResult.value = movies
                },{
                    e -> error.value = e.message
                }
            )
    }


    fun getFavoritedMovies() {
        moviePopularUseCase.getFavoritedMovies()
            .subscribeOn(Schedulers.io()) //define em qual thread vai fazer requisição
            .observeOn(AndroidSchedulers.mainThread()) //para onde vai enviar
            .subscribe( //vai ter o objeto de resposta
                { movies ->
                    movieFavoriteResult.value = movies
                },{
                        e -> error.value = e.message
                }
            )

    }

    fun update(movie: Movie){
        moviePopularUseCase.update(movie)
        Log.d("teste na view model", movie.toString())
    }
}