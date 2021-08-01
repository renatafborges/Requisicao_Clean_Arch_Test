package com.renata.projeto_integrador.allmovies.data.model

data class Movie(

    val id: Int,
    val poster_path: String,
    val title: String,
    val vote_average: Double,
    var isFavorite: Boolean = false,

)
