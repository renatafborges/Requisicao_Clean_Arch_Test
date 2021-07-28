package com.renata.projeto_integrador.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val adult: Boolean,
    @SerializedName("genre_ids")
    val genreIds : List<Int>,
    val id: Int,
    val imdb_id: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val title: String,
    val vote_average: Double,
    val vote_count: Int

)
