//package com.renata.projeto_integrador.moviedetails.domain
//
//import com.renata.projeto_integrador.allmovies.data.model.MovieResponse
//import com.renata.projeto_integrador.allmovies.data.repository.MoviePopularRepository
//import com.renata.projeto_integrador.moviedetails.data.model.MovieDetails
//import com.renata.projeto_integrador.moviedetails.data.repository.MovieDetailsRepository
//import io.reactivex.Single
//
//
//movie id = ?
//const val API_KEY = "893ae533a711d05e99a29d52a30419ed"
//const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
//
////injeção de dependencias
//
//class MovieDetailsUseCase {
//    //repository = dependencia
//    val repository = MovieDetailsRepository()
//
//    fun getMovieDetails(): Single<MovieDetails> {
//        return repository.getMovieDetails(movieId)
//    }
//}