package com.renata.projeto_integrador.allmovies.data.model

data class Movie(

    val id: Int,
    val poster_path: String,
    val title: String,
    val vote_average: Double,
    val release_date: String,
    val runtime: Int,
    val overview: String,
    var isFavorite: Boolean = false

)
