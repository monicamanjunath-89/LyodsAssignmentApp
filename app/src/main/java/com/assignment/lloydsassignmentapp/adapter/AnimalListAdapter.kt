package com.assignment.lloydsassignmentapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.assignment.domain.models.AnimalModel
import com.assignment.lloydsassignmentapp.R
import com.assignment.lloydsassignmentapp.common.ListItemClickListener
import com.bumptech.glide.Glide

class AnimalListAdapter(private val onClickListener: ListItemClickListener, private val mList: List<AnimalModel>) : RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.list_item.setOnClickListener{onClickListener.onListItemClickListener(mList[position])}
        val item = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.name.text = item.name
        holder.type.text = item.animal_type

        Glide.with(holder.image.context)
            .load(item.image_link) // image url
            .into(holder.image)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val list_item : ConstraintLayout = itemView.findViewById(R.id.list_item)
        val image: ImageView = itemView.findViewById(R.id.image)
        val name: TextView = itemView.findViewById(R.id.animal_name)
        val type: TextView = itemView.findViewById(R.id.animal_type)
    }
}