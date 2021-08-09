package com.renata.projeto_integrador.allmovies.presentation.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie
import com.renata.projeto_integrador.allmovies.domain.usecase.POSTER_BASE_URL
import com.renata.projeto_integrador.allmovies.presentation.MovieListener
import com.squareup.picasso.Picasso

//import com.renata.projeto_integrador.allmovies.presentation.MovieListener

class MoviesAdapter(
    val listener: MovieListener,
    var results: MutableList<Movie> = mutableListOf()): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(view : View): RecyclerView.ViewHolder(view){

        var imgMovie: ImageView? = view.findViewById(R.id.imgMovie)
        var titleMovie: TextView? = view.findViewById(R.id.titleMovie)
        var rateMovie: TextView? = view.findViewById(R.id.txtVoteAverage)
        var favBtn: ToggleButton? = view.findViewById(R.id.favBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = results[position]

        holder.titleMovie?.text = results[position].title
        holder.rateMovie?.text = results[position].vote_average.toString()
        Picasso.get().load(POSTER_BASE_URL + movie.poster_path).into(holder.imgMovie)
        holder.favBtn?.isChecked = results[position].isFavorite
        holder.favBtn?.setOnClickListener{
            listener?.onFavoriteClickedListener(results[position])
            Log.d("test", results[position].isFavorite.toString())
        }
    }

    fun updateList(newList: List<Movie>) {
        this.results.clear()
        if (newList != null) {
            this.results.addAll(newList)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return results.size
    }
}
