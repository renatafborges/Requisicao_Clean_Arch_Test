package com.renata.projeto_integrador.allmovies.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.solver.LinearSystem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.presentation.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_all_movies.*
import kotlinx.android.synthetic.main.movie_list_item.*
import retrofit2.Call
import retrofit2.Response


class AllMoviesFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>? = null
    private lateinit var moviesAdapter: MoviesAdapter

    var movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    var list = mutableListOf<Movie>()


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_movies, container, false)
    }


    //logica vai estar aqui, para não ficar repetindo na activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rvMovies = view.findViewById<RecyclerView>(R.id.rvMovie)

        rvMovie.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(requireActivity())
            // set the custom adapter to the RecyclerView
            adapter = MoviesAdapter(list)

        }

        val viewModel = ViewModelProviders.of(this).get(PopularMovieViewModel::class.java)

        viewModel.getPopularMovies()
        viewModel.movieResult.observe(viewLifecycleOwner, Observer{
//            titleMovie.text = it.results[0].title
//            txtVoteAverage.text = it.results[0].vote_average.toString()

        })
    }
}