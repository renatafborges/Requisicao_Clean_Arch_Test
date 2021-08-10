package com.renata.projeto_integrador.moviedetails.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.presentation.MOVIE_ID
import com.renata.projeto_integrador.moviedetails.domain.POSTER_BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MoviesDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)

        val movieId = intent.getIntExtra(MOVIE_ID, -1)
        if (movieId != null) {
            viewModel.getMovieDetails(movieId)
            viewModel.movieResult.observe(this, Observer { movie ->
                Picasso.get().load(POSTER_BASE_URL + movie.poster_path).into(posterMovie)
                movieTitle.text = movie.title
            })
        }
    }
}