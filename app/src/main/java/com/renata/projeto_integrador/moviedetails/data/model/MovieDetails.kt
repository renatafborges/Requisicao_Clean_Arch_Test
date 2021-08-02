package com.renata.projeto_integrador.moviedetails.data.model

data class MovieDetails(

    val id: Int,
    val poster_path: String,
    val vote_average: Double,
    val title: String,
    val release_date: String,
    val runtime: Int,
    val overview: String,
    var isFavorite: Boolean = false
//    val adult: Boolean
//    @SerializedName("genre_ids")
//    val genreIds : List<Int>,

)
