package com.mrmukto.earthquake.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mrmukto.earthquake.databinding.EarthquakeRowBinding
import com.mrmukto.earthquake.models.EarthquakeModel
import com.mrmukto.earthquake.network.getFormattedDate

class EarthquakeAdapter : ListAdapter<EarthquakeModel.Metadata, EarthquakeAdapter.EarthquakeViewholder>(
    ForecastDiffUtil()
){
    class EarthquakeViewholder(val binding: EarthquakeRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EarthquakeModel.Metadata) {
            binding.item = item
        }

    }
    class ForecastDiffUtil : DiffUtil.ItemCallback<EarthquakeModel.Metadata>(){
        override fun areItemsTheSame(
            oldItem: EarthquakeModel.Metadata,
            newItem: EarthquakeModel.Metadata
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: EarthquakeModel.Metadata,
            newItem: EarthquakeModel.Metadata
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewholder {
        val binding = EarthquakeRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return EarthquakeViewholder(binding)
    }

    override fun onBindViewHolder(holder: EarthquakeViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
@BindingAdapter("app:setDateTime")
fun setDateTime(textView: TextView, dt: Long) {
    textView.text = getFormattedDate(dt, "MMM dd, yyyy HH:mm")
}