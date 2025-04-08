package com.example.m2tmdbapp2025

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m2tmdbapp2025.databinding.PersonItemBinding
import com.example.m2tmdbapp2025.model.Person
import com.squareup.picasso.Picasso

class PersonPopularAdapter(private val persons: ArrayList<Person>, context: Context) : RecyclerView.Adapter<PersonPopularAdapter.PersonPopularViewHolder>() {
    private var maxPopularity : Double = 0.0
    private val scoreRatings: Array<String> = context.resources.getStringArray(R.array.score_rating)
    private val ratingColors: Array<String> = context.resources.getStringArray(R.array.rating_colors)

    init {
        setMaxPopularity()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonPopularViewHolder {
        val binding = PersonItemBinding.inflate((LayoutInflater.from(parent.context)), parent, false)
        return PersonPopularViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PersonPopularViewHolder,
        position: Int
    ) {
        val curItem = persons[position]
        holder.binding.nameTv.text = curItem.name
        holder.binding.knownForTv.text = curItem.knownForDepartment
        holder.binding.popularityTv.text = curItem.popularity.toString()
        Picasso.get()
            .load(ApiClient.IMAGE_BASE_URL + curItem.profilePath)
            .placeholder(android.R.drawable.progress_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.binding.photoIv)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    private fun getRating(value: Double?, max: Double): String {
        val index = mapValueToIndex(value, max, scoreRatings.size)
        return scoreRatings[index]
    }

    private fun getScoreColor(value: Double?, max: Double): Int {
        val index = mapValueToIndex(value, max, ratingColors.size)
        return ratingColors[index].toInt()
    }

    private fun mapValueToIndex(value: Double?, max: Double, size: Int): Int =
        if (value != null && max > 0.0) ((size * value) / max).toInt().coerceAtMost(size - 1) else 0

    fun setMaxPopularity() {
        maxPopularity = 0.0
        for (p in persons) {
            if (p.popularity != null && p.popularity!! > maxPopularity) maxPopularity = p.popularity!!
        }
    }

    class PersonPopularViewHolder(var binding : PersonItemBinding) : RecyclerView.ViewHolder(binding.root)

    /* ==========================================================================================
      * | Same implementation done with 'findViewById' to understand the role of the view holder |
      * ==========================================================================================

    // Create new views (invoked by the layout manager)
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

     */

}

