package com.example.m2tmdbapp2025

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m2tmdbapp2025.model.Person
import com.squareup.picasso.Picasso

class PersonPopularAdapter(private val persons: ArrayList<Person>) : RecyclerView.Adapter<PersonPopularAdapter.PersonPopularViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonPopularViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return PersonPopularViewHolder(view)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonPopularViewHolder, position: Int) {
        val curItem = persons[position]
        holder.nameTv.text = curItem.name
        holder.knownForTv.text = curItem.knownForDepartment
        holder.popularityTv.text = curItem.popularity.toString()
        Picasso.get()
            .load(ApiClient.IMAGE_BASE_URL + curItem.profilePath)
            .placeholder(android.R.drawable.progress_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.photoIv)
    }

    class PersonPopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv: TextView
        val knownForTv: TextView
        val popularityTv: TextView
        val photoIv: ImageView
        init {
            nameTv = view.findViewById(R.id.name_tv)
            knownForTv = view.findViewById(R.id.known_for_tv)
            popularityTv = view.findViewById(R.id.popularity_tv)
            photoIv = view.findViewById(R.id.photo_iv)
        }
    }
}

