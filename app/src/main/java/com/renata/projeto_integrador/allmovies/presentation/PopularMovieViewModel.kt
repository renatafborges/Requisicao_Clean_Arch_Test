package com.renata.projeto_integrador.allmovies.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



class PopularMovieViewModel(): ViewModel() {

    val moviePopularUseCase = PopularMovieUseCase()
    val movieResult: MutableLiveData<MovieResponse> = MutableLiveData()
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

}