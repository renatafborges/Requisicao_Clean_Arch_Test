package com.renata.projeto_integrador.allmovies.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.presentation.adapter.MoviesAdapter
import com.renata.projeto_integrador.moviedetails.presentation.MoviesDetailsActivity
import kotlinx.android.synthetic.main.fragment_all_movies.*


const val MOVIE_ID = "movieId"

class AllMoviesFragment : Fragment(), MovieListener {

    var list = mutableListOf<Movie>()
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var viewModel: PopularMovieViewModel

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
        viewModel = ViewModelProvider(requireActivity()).get(PopularMovieViewModel::class.java)

        var list = mutableListOf<Movie>()
        moviesAdapter = MoviesAdapter(listener = this, list)

        val rvMovie = view.findViewById<RecyclerView>(R.id.rvMovie)

        rvMovie.apply {
            adapter = moviesAdapter
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
        }

        viewModel.getPopularMovies()
        viewModel.movieResult.observe(viewLifecycleOwner, Observer {
            moviesAdapter.updateList(it)
        })
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(context, MoviesDetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

//    override fun onFavoriteClickedListener(movie: Movie) {
//        Log.d("On favorite movies", movie.toString())
//        movie.isFavorite = !movie.isFavorite
//        viewModel.update(movie)
//    }

}