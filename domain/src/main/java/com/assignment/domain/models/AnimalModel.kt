package com.assignment.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class  AnimalModel(
    val name : String,
    val latin_name : String,
    val animal_type : String,
    val active_time : String,
    val length_min : Double,
    val length_max : Double,
    val weight_min : Double,
    val weight_max : Double,
    val lifespan : Int,
    val habitat : String,
    val diet : String,
    val geo_range : String,
    val image_link : String,
    val id : Int
) : Parcelable