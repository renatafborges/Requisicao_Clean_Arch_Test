package com.renata.projeto_integrador.moviedetails.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
import com.renata.projeto_integrador.moviedetails.domain.MovieDetailsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailsViewModel() : ViewModel() {

    val movieDetailsUseCase = MovieDetailsUseCase()
    val movieResult: MutableLiveData<MovieDetails> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()

    fun getMovieDetails(movieId: Int) {
        movieDetailsUseCase.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { movies ->
                    movieResult.value = movies
                }, { e ->
                    error.value = e.message
                }
            )
    }
}