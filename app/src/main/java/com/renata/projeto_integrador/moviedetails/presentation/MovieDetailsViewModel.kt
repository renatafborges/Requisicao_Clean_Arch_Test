//package com.renata.projeto_integrador.moviedetails.presentation
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
//import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase
//import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
//import com.renata.projeto_integrador.moviedetails.domain.MovieDetailsUseCase
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//
//class MovieDetailsViewModel(): ViewModel() {
//
//    val movieDetailsUseCase = MovieDetailsUseCase()
//    val movieResult: MutableLiveData<MovieDetails> = MutableLiveData()
//    val error: MutableLiveData<String> = MutableLiveData()
//
//    fun getMovieDetails() {
//        movieDetailsUseCase.getMovieDetails()
//            .subscribeOn(Schedulers.io()) //define em qual thread vai fazer requisição
//            .observeOn(AndroidSchedulers.mainThread()) //para onde vai enviar
//            .subscribe( //vai ter o objeto de resposta
//                { movies ->
//                    movieResult.value = movies
//                },{
//                        e -> error.value = e.message
//                }
//            )
//        }
//    }