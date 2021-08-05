package com.renata.projeto_integrador.allmovies.data.model

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val genreName: String
)