package com.renata.projeto_integrador.domain.repository

import com.renata.projeto_integrador.data.model.MovieResponse
import io.reactivex.Single


// conectar duas classes
// movie popular com use case

interface MoviePopularRepositoryContract {

    fun getPopularMovies(apiKey: String): Single<MovieResponse>

}