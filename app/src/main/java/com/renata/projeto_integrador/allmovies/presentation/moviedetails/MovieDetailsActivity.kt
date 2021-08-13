package com.renata.projeto_integrador.allmovies.presentation.moviedetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.domain.usecase.POSTER_BASE_URL
import com.renata.projeto_integrador.allmovies.presentation.allmovies.MOVIE_ID
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
            viewModel.movieDetailsResult.observe(this, Observer { movie ->
                Picasso.get().load(POSTER_BASE_URL + movie.poster_path).into(posterMovie)
                movieTitle.text = movie.title
                movieYear.text = movie.release_date
                movieDuration.text = movie.runtime.toString()
                movieSynopsis.text = movie.overview
                ratingMovieInfoAct.text = movie.vote_average.toString()
            })
        }
    }
}



