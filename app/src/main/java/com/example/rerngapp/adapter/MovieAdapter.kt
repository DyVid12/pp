package com.example.rerngapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rerngapp.R
import com.example.rerngapp.model.Result

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movieList = mutableListOf<Result>()

    // Function to update the list of movies
    fun submitList(movies: List<Result>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    // ViewHolder class for binding views
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        private val moviePoster: ImageView = itemView.findViewById(R.id.moviePoster)

        fun bind(movie: Result) {
            movieTitle.text = movie.title

            // Load the movie poster using Glide
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                .placeholder(R.drawable.avatar)  // Ensure you have a placeholder image in drawable
                .into(moviePoster)
        }
    }
}
