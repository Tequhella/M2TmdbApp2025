package com.example.m2tmdbapp2025

import android.hardware.Sensor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m2tmdbapp2025.databinding.SensorItemBinding

class SensorListAdapter(
    val sensors: ArrayList<Sensor>,
    private val sensorItemClickListener: OnSensorItemClickListener) : RecyclerView.Adapter<SensorListAdapter.SensorItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SensorItemViewHolder {
        val binding = SensorItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return SensorItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SensorItemViewHolder, position: Int) {
        holder.binding.sensorItem = sensors[position]
    }

    override fun getItemCount() = sensors.size

    // ------------------ VIEW HOLDER CLASS ----------------------
    inner class SensorItemViewHolder(
        val binding: SensorItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
           binding.sensorItemView.setOnClickListener {
                sensorItemClickListener.onSensorItemClicked(adapterPosition)
           }
        }
    }
}