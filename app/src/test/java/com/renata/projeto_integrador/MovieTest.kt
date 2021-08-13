package com.renata.projeto_integrador

import com.renata.projeto_integrador.allmovies.data.model.Movie
import junit.framework.Assert.assertEquals
import org.junit.Test

///*
//* 1. Dado que o usuário queria saber mais informações sobre o filme
//* Quando ele clicar em qualquer campo do filme
//* Então deve ser redirecionado para a tela de detalhes
//*
//*
//* 2. Dado que o usuário gostei de um filme
//*Quando ele tocar no coração
//*Então esse filme será redirecionado aos favoritos
//*
//*
//* 3. Dado que o usuário não goste mais de um filme
//* Quando ele tocar no coração dentro da tela de favoritos
//* Então esse filme será removido dos favoritos /


class MovieDetailsTest {
    @Test
    fun show_movie_details() {
//ARRANGE
        val movie = Movie(
            id = 123456,
            poster_path = "https://image.tmdb.org/t/p/w342",
            title = "The Suicide Squad",
            vote_average = 7.8,
            isFavorite = false
        )
//ACT
        val movieId = movie.id
        val moviePoster = movie.poster_path
        val movieTitle = movie.title
        val movieVote = movie.vote_average
        val movieIsFavorite = movie.isFavorite

//ASSERT
        assertEquals(123456, movieId)
        assertEquals("https://image.tmdb.org/t/p/w342", moviePoster)
        assertEquals("The Suicide Squad", movieTitle)
        assertEquals(7.8, movieVote)
        assertEquals(false, movieIsFavorite)
    }
}