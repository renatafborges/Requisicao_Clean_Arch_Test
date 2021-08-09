
package com.renata.projeto_integrador.allmovies.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.presentation.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_all_movies.*


class FavoriteMoviesFragment : Fragment(), MovieListener {

    var list = mutableListOf<Movie>()
    private lateinit var moviesAdapter : MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(PopularMovieViewModel::class.java)
//        rvMovie.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        var list = mutableListOf<Movie>()
        moviesAdapter = MoviesAdapter(listener = this, list)

        rvMovie.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            // set the custom adapter to the RecyclerView
        }

        viewModel.getFavoritedMovies()
        viewModel.movieFavoriteResult.observe(requireActivity(), Observer {
            moviesAdapter.updateList(it)

        })

        Log.d("estouaqui", "estouaqui")
    }

    override fun openMovieDetails(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun onFavoriteClickedListener(movie: Movie) {
        Log.d("On favorite movies", movie.toString())
        movie.isFavorite = !movie.isFavorite
        val viewModel = ViewModelProviders.of(this).get(PopularMovieViewModel::class.java)
        viewModel.update(movie)
    }



}