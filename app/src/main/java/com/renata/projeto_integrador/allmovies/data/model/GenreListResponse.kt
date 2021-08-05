package com.renata.projeto_integrador.allmovies.data.model

import com.google.gson.annotations.SerializedName

data class GenreListResponse(
    @SerializedName("genres")
    val genres: List<GenreResponse>
)