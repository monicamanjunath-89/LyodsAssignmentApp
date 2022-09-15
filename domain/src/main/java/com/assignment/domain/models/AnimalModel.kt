package com.assignment.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class  AnimalModel(
    val name : String,
    val latinName : String,
    val animalType : String,
    val activeTime : String,
    val lengthMin : Double,
    val lengthMax : Double,
    val weightMin : Double,
    val weightMax : Double,
    val lifespan : Int,
    val habitat : String,
    val diet : String,
    val geoRange : String,
    val imageLink : String,
    val id : Int
) : Parcelable