package com.renata.projeto_integrador.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.data.model.MovieResponse
import com.renata.projeto_integrador.domain.usecase.MoviePopularUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviePopularViewModel(): ViewModel() {

    val moviePopularUseCase = MoviePopularUseCase()
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
            ).dispose()
    }

}