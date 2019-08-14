package com.example.sprintchallenge1again.model

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.movie_item_layout.view.*





class MovieListAdapter(val data: MutableList<Movie>): RecyclerView.Adapter<MovieListAdapter.ViewHolder>(){



    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val movieTextView = view.movie_title_view







    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(com.example.sprintchallenge1again.R.layout.movie_item_layout, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTextView.text = data[position].movieTitle

    }





}