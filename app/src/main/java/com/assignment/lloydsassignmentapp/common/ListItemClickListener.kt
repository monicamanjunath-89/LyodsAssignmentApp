package com.assignment.lloydsassignmentapp.common

import com.assignment.domain.models.AnimalModel

//Interface to pass list item click event
interface ListItemClickListener {
    fun onListItemClickListener(item: AnimalModel)
}