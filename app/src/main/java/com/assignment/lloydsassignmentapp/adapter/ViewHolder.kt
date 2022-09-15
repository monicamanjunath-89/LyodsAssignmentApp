package com.assignment.lloydsassignmentapp.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.assignment.lloydsassignmentapp.databinding.AnimalItemBinding

// Holds the views for adding it to image and text
class ViewHolder(private val binding: AnimalItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val list_item : ConstraintLayout = binding.listItem
    val image: ImageView = binding.image
    val name: TextView = binding.animalName
    val type: TextView = binding.animalType
}