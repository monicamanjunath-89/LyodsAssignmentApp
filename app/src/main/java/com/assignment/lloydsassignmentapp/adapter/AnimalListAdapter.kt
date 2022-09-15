package com.assignment.lloydsassignmentapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.domain.models.AnimalModel
import com.assignment.lloydsassignmentapp.common.ListItemClickListener
import com.assignment.lloydsassignmentapp.databinding.AnimalItemBinding
import com.bumptech.glide.Glide

class AnimalListAdapter(private val onClickListener: ListItemClickListener, private val mList: List<AnimalModel>) : RecyclerView.Adapter<ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (AnimalItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.list_item.setOnClickListener{onClickListener.onListItemClickListener(mList[position])}
        val item = mList[position]

        // sets the text and image to the textview and imageview from our ViewHolder class
        holder.apply {
            name.text = item.name
            type.text = item.animalType
            Glide.with(image.context)
                .load(item.imageLink) // image url
                .into(image)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }
}