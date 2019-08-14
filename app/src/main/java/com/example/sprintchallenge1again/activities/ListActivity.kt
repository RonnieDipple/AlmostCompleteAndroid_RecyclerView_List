package com.example.sprintchallenge1again.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.sprintchallenge1again.R
import com.example.sprintchallenge1again.model.Movie
import com.example.sprintchallenge1again.model.Movie.Companion.MOVIE_KEY
import com.example.sprintchallenge1again.model.MovieListAdapter
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.movie_item_layout.*
import java.io.Serializable

class ListActivity : AppCompatActivity() {
    companion object {
        const val MOVIE_REQUEST_CODE = 123

    }

   private val movieList = mutableListOf<Movie>()
    private val adapter = MovieListAdapter(movieList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        add_movie_button.setOnClickListener {

            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent,
                MOVIE_REQUEST_CODE
            )
        }






        movie_list_layout.setHasFixedSize(false)
        val manager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)

        movie_list_layout.layoutManager = manager
        movie_list_layout.adapter = adapter







       
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == MOVIE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            val movie = data?.getSerializableExtra(MOVIE_KEY) as Movie
            movieList.add(movie)
            adapter.notifyItemInserted(movieList.size-1)
            //displayMovies()

        }
    }


   /* fun createTextView(movie: Movie): TextView {
        val textView = TextView(this)
        textView.textSize = 16f
        textView.text = movie.movieTitle
        if (movie.isWatched)
            textView.setTextColor(resources.getColor(R.color.colorPrimary))
        else
            textView.setTextColor(resources.getColor(R.color.colorAccent))


        return textView

    }*/

    /*fun displayMovies() {
       /* movie_list_layout.removeAllViews()
        for (x in movieList) {
            val textView = createTextView(x)
            movie_list_layout.addView(textView)*/


        }

         Another way
    movieList.forEach {
        val textView = createTextView(it)
        movie_list_layout.addView(textView)
    }
    */
    }


