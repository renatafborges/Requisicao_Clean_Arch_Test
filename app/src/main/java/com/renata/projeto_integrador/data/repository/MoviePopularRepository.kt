package com.renata.projeto_integrador.data.repository

import com.renata.projeto_integrador.data.RetrofitService
import com.renata.projeto_integrador.data.model.MovieResponse
import io.reactivex.Single

class MoviePopularRepository {
     fun getPopularMovies(apiKey: String): Single<MovieResponse> {
        return RetrofitService.service.getPopularMovie(apiKey)
    }
}