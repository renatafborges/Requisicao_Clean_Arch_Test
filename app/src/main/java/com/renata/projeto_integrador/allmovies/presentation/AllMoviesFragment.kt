package com.renata.projeto_integrador.allmovies.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.solver.LinearSystem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.presentation.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_all_movies.*
import kotlinx.android.synthetic.main.movie_list_item.*


class AllMoviesFragment : Fragment() {

    private lateinit var rvMovie : RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(PopularMovieViewModel::class.java)

        viewModel.getPopularMovies()
        viewModel.movieResult.observe(this, Observer{
            titleMovie.text = it.results[0].title
            txtVoteAverage.text = it.results[0].vote_average.toString()

        })

    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_movies, container, false)

        // Add the following lines to create RecyclerView
        rvMovie = view.findViewById(R.id.rvMovie)
        rvMovie.hasFixedSize()
        rvMovie.layoutManager = LinearLayoutManager (context)
        rvMovie.adapter = MoviesAdapter

    }

}