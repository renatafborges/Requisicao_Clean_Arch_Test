package com.renata.projeto_integrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.renata.projeto_integrador.presentation.MoviePopularViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MoviePopularViewModel::class.java)

        viewModel.getPopularMovies()
        viewModel.movieResult.observe(this, Observer{
            teste_api.text = it.results[0].title
        })
    }
}