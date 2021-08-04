package com.renata.projeto_integrador.allmovies.data.model

data class MovieResponse(
    val page: Int,
   //@SerializedName ("results")
    val results: MutableList<Movie>,
    val total_results: Int,
    val total_pages: Int

)