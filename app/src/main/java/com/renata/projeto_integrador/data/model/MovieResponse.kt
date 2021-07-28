package com.renata.projeto_integrador.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val page: Int,
   //@SerializedName ("results")
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int

)