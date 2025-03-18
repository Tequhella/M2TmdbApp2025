package com.example.m2tmdbapp2025

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m2tmdbapp2025.model.Person

class PersonPopularAdapter(private val persons: ArrayList<Person>) : RecyclerView.Adapter<PersonPopularAdapter.PersonPopularViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonPopularViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonPopularViewHolder, position: Int) {
        TODO("Not yet implemented")
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

