package com.renata.projeto_integrador.allmovies.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.data.model.Movie

class MoviesAdapter(var results: MutableList<Movie>): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    class MoviesViewHolder(view : View): RecyclerView.ViewHolder(view){
        var imgMovie: ImageView? = view.findViewById(R.id.imgMovie)
        var titleMovie: TextView? = view.findViewById(R.id.titleMovie)
        var rateMovie: TextView? = view.findViewById(R.id.txtVoteAverage)
//        var favBtn: ToggleButton? = view.findViewById(R.id.favIcon)

//      fun onBind(movie: Movie) {
//          imgMovie?.let {
//                Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(
//                 it
//              )
//           }
//      }
    }

    fun updateList(newList: MutableList<Movie>) {
        this.results.removeAll(results)
        if (newList != null) {
            this.results = newList
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.titleMovie?.text = results[position].title
        holder.rateMovie?.text = results[position].vote_average.toString()
    }

    override fun getItemCount(): Int {
        return results.size
    }

}