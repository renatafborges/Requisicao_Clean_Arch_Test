package com.renata.projeto_integrador.moviedetails.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.presentation.MOVIE_ID
import com.renata.projeto_integrador.moviedetails.domain.POSTER_BASE_URL
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
            viewModel.movieResult.observe(this, Observer { movie ->
                Picasso.get().load(POSTER_BASE_URL + movie.poster_path).into(posterMovie)
                movieTitle.text = movie.title
            })
        }

    }


//    private val viewModel = MovieDetailsViewModel()
//
//    private lateinit var movieImage : ShapeableImageView
//    private lateinit var titleMovie : TextView
//    private lateinit var movieYear : TextView
//    private lateinit var certification : TextView
//    private lateinit var movieLength : TextView
//    private lateinit var synopsis : TextView
//    private lateinit var movieRating : TextView
//    private lateinit var returnButton : ImageButton
//    private lateinit var favButton : ToggleButton
//    private val viewModelDetails = MoviesViewModel()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_movies_details)
//
//        //Chama os elementos dos detalhes dos filmes.
//        movieImage = findViewById(R.id.imgMovieBanner)
//        titleMovie = findViewById(R.id.txtTitle)
//        movieYear = findViewById(R.id.txtMovieYear)
//        certification = findViewById(R.id.txtPage)
//        movieLength = findViewById(R.id.txtMovieLength)
//        synopsis = findViewById(R.id.txtSinopsys)
//        movieRating = findViewById(R.id.txtMovieRating)
//        returnButton = findViewById(R.id.btnReturn)
//        favButton = findViewById(R.id.btnFavorite)
//
//        //Chamada da Recyclerview do CastAdapter.
//        containerCast = findViewById(R.id.rcvMovieCast)
//        castAdapter = CastAdapter(context = this)
//        containerCast.adapter = castAdapter
//        containerCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        //Chamada da Recyclerview do GenresAdapter.
//        containerGenres = findViewById(R.id.rcvMovieGenres)
//        genresAdapter = GenresAdapter(context = this)
//        containerGenres.adapter = genresAdapter
//        containerGenres.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        //Aqui se está chamando as informações enviadas pela MoviesAdapter.
//        val infos = intent.extras?.get("movies") as Infos?
//
//        //Aqui se está chamando as informações enviadas pela função da ViewModel referente ao "certification" dos detalhes do filme (em "release_date").
//        if (infos != null) {
//            viewModelDetails.getInfosDetails(movieId = infos.id)
//        }
//
//        //Aqui se está chamando as informações enviadas pela função da ViewModel referente à recyclerview do "cast" dos detalhes do filme.
//        if (infos != null) {
//            viewModel.getCastInfos(movieId2 = infos.id)
//        }
//
//        //Aqui se está chamando as informações enviadas pela função da ViewModel referente aos gêneros dos filmes.
//        if (infos != null) {
//            viewModel.getGenresInfos(movieId3 = infos.id)
//        }
//
//        //Aqui se está chamando as informações enviadas pela função da ViewModel referente ao "runtime" dos filmes.
//        if (infos != null) {
//            viewModel.getMoviesRuntime(movieId5 = infos.id)
//        }
//
//        //Aqui se está inserindo os elementos da classe "Infos" na caixa de texto.
//        infos?.let{
//            Glide.with(this).load("https://image.tmdb.org/t/p/w500" + it.backdrop_path).into(movieImage)
//            titleMovie.text = it.title
//            movieRating.text = it.vote_average.toString() + " %"
//            synopsis.text = it.overview
//            movieYear.text = it.release_date.substring(0,4)
//            favButton.isChecked = it.favoriteCheck
//
//            //Aqui se está aplicando o parâmetro "id" às funções criadas abaixo.
//            setupObserveDetailsList(it.id)
//            setupCastObserveList(it.id)
//            setupGenresTypesObserveList(it.id)
//            setupRuntimeObserveList(it.id)
//        }
//
//    }
//
//    //Aqui se está dizendo "observe a viewmodel e quando algo acontecer a ela a atrele à caixa de texto".
//    fun setupObserveDetailsList(movieId : Int) {
//        viewModelDetails.detailsLiveData.observe(this,
//            {
//                certification.text = it.toString()
//            })
//    }
//
//    //Aqui se está dizendo "observe a viewmodel e quando algo acontecer a ela a atrele ao adapter".
//    fun setupCastObserveList(movieId2 : Int) {
//        viewModel.castLiveData.observe(this,
//            { response ->
//                response?.let {
//                    castAdapter.dataSetCast.clear()
//                    castAdapter.dataSetCast.addAll(it)
//                    castAdapter.notifyDataSetChanged()
//                }
//            })
//    }
//
//    //Aqui se está dizendo "observe a viewmodel e quando algo acontecer a ela a atrele ao adapter".
//    fun setupGenresTypesObserveList(movieId3 : Int) {
//        viewModel.allGenresLiveData.observe(this,
//            { response ->
//                response?.let {
//                    genresAdapter.dataSetGenres.clear()
//                    genresAdapter.dataSetGenres.addAll(it)
//                    genresAdapter.notifyDataSetChanged()
//                }
//            })
//    }
//
//    //Aqui se criou uma função para ajustar o tempo do "runtime" que vem apenas em minutos para horas e minutos.
//    fun convertRuntime(totalMinutes: Int): String? {
//        var minutes = Integer.toString(totalMinutes % 60)
//        minutes = if (minutes.length == 1) "0$minutes" else minutes
//        return (totalMinutes / 60).toString() + "h" + minutes + "min"
//    }
//
//    //Aqui se está dizendo "observe a viewmodel e quando algo acontecer a ela a atrele ao adapter".
//    fun setupRuntimeObserveList(movieId5 : Int) {
//        viewModel.runtimeLiveData.observe(this,
//            {
//                movieLength.text = convertRuntime(it.runtime)
//            })
//    }

}