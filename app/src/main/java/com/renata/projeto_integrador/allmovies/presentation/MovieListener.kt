package com.renata.projeto_integrador.allmovies.presentation

import com.renata.projeto_integrador.allmovies.data.model.Movie

interface MovieListener {
    fun openMovieDetails(movieId: Int)
//    fun onFavoriteClickedListener(movie: Movie)
}