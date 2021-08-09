package com.renata.projeto_integrador.allmovies.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.presentation.adapter.MoviesAdapter
import com.renata.projeto_integrador.moviedetails.presentation.MovieDetailsActivity
import kotlinx.android.synthetic.main.fragment_all_movies.*

class AllMoviesFragment : Fragment(), MovieListener {


    var list = mutableListOf<Movie>()
    private lateinit var moviesAdapter : MoviesAdapter
//    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_movies, container, false)
    }


    //logica vai estar aqui, para não ficar repetindo na activity
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

        viewModel.getPopularMovies()
        viewModel.movieResult.observe(requireActivity(), Observer {
            moviesAdapter.updateList(it.results)

        })
    }

    override fun openMovieDetails(movieId: Int) {
//       vou ter que invocar outra activity -> moviedetails
    }

    override fun onFavoriteClickedListener(movie: Movie) {
        movie.isFavorite = !movie.isFavorite
    }

}