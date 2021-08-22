package com.renata.projeto_integrador.allmovies.presentation.allmovies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PopularMovieViewModel(): ViewModel() {

    val moviePopularUseCase = PopularMovieUseCase()
    val movieResult = MutableLiveData<List<Movie>>(mutableListOf())
    var movieFavoriteResult = MutableLiveData<List<Movie>>(mutableListOf())
    val error: MutableLiveData<String> = MutableLiveData()
    val dispose = CompositeDisposable()

    fun getPopularMovies() {
        moviePopularUseCase.getPopularMovies() //contexto: single list movie
            .subscribeOn(Schedulers.io()) //definindo em qual thread vai ser executada a busca dos filmes
            .observeOn(AndroidSchedulers.mainThread()) //para qual thread vai enviar dps que finalizar o trabalho
            .subscribe( //uma resposta de sucesso e uma de erro
                { movies ->
                    movieResult.value = movies //atualizando a livedata
                },{
                        e -> error.value = e.message //tratamento dos erros -> tela de erro
                } //vai matar essa thread
            ).run { dispose.add(this) }
    }

    fun getFavoritedMovies() {
        movieFavoriteResult = moviePopularUseCase.getFavoritedMovies()
    }

    fun update(movie: Movie){
        moviePopularUseCase.update(movie)
    }
}