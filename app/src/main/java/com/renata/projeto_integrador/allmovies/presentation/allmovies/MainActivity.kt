package com.renata.projeto_integrador.allmovies.presentation.allmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.renata.projeto_integrador.R
import com.renata.projeto_integrador.allmovies.presentation.allmovies.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = listOf<Fragment>(AllMoviesFragment(), FavoriteMoviesFragment())
        val fragmentTitle = listOf("All Movies", "Favorite Movies")

        val viewPagerAdapter = ViewPagerAdapter(
            fragmentManager = this.supportFragmentManager,
            fragmentList = fragmentList,
            fragmentTitleList = fragmentTitle
        )
        movieViewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(movieViewPager)
    }
}