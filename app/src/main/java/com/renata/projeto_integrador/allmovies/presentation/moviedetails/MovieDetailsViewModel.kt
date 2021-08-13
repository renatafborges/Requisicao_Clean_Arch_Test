package com.renata.projeto_integrador.allmovies.presentation.moviedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailsViewModel : ViewModel() {

    val popularMovieUseCase = PopularMovieUseCase()
    val movieDetailsResult: MutableLiveData<Movie> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()

    fun getMovieDetails(movieId: Int) {
        popularMovieUseCase.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { movies ->
                    movieDetailsResult.value = movies
                }, { e ->
                    error.value = e.message
                }
            )
    }
}