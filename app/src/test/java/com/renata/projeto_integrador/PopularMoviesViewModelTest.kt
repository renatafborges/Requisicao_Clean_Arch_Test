package com.renata.projeto_integrador

import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.domain.usecase.PopularMovieUseCase
import com.renata.projeto_integrador.allmovies.presentation.allmovies.PopularMovieViewModel
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito

class PopularMoviesViewModelTest {

    val test = Single. just -> retornar uma lista de objeto
    val viewModel = PopularMovieViewModel()
    val useCase = PopularMovieUseCase()
    val movieList = listOf(Movie(123, "", "",7.5,
        "", 145, "", false))

    @Test
    fun getPopularMovies() {
    Mockito.`when`(useCase.getPopularMovies()).thenReturn(movieList)
        Mockito.verify()

    }
}

//dado esse retorno
// verifica se chama os métodos sucesso
// e se der erro -> chamar os método de erro.