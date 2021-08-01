package com.renata.projeto_integrador.allmovies.data.repository

import com.renata.projeto_integrador.allmovies.data.RetrofitService
import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
import io.reactivex.Single

class MoviePopularRepository {
     fun getPopularMovies(apiKey: String): Single<MovieResponse> {
        return RetrofitService.SERVICE.getPopularMovie(apiKey)
    }
}