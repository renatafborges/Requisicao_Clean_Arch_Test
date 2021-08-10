package com.renata.projeto_integrador.allmovies.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.presentation.adapter.MoviesAdapter
import com.renata.projeto_integrador.moviedetails.presentation.MoviesDetailsActivity
import kotlinx.android.synthetic.main.fragment_all_movies.*

class FavoriteMoviesFragment : Fragment(), MovieListener {

    var list = mutableListOf<Movie>()
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var viewModel: PopularMovieViewModel
    val data = "Renata"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(PopularMovieViewModel::class.java)

        moviesAdapter = MoviesAdapter(listener = this, list)

        rvMovie.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
            // set the custom adapter to the RecyclerView
        }

        viewModel.getFavoritedMovies()
        viewModel.movieFavoriteResult.observe(viewLifecycleOwner, Observer {
            moviesAdapter.updateList(it)
        })
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(context, MoviesDetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun onFavoriteClickedListener(movie: Movie) {
        movie.isFavorite = !movie.isFavorite
        viewModel.update(movie)
    }

}