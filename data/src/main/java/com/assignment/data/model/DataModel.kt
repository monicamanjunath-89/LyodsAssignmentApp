package com.assignment.data.model

import com.google.gson.annotations.SerializedName

data class  DataModel(
    @SerializedName("name")
    val animalName : String,
    @SerializedName("latin_name")
    val animalLatinName : String,
    @SerializedName("animal_type")
    val type : String,
    @SerializedName("active_time")
    val animalActiveTime : String,
    @SerializedName("length_min")
    val minLen : Double,
    @SerializedName("length_max")
    val maxLen : Double,
    @SerializedName("weight_min")
    val minWeight : Double,
    @SerializedName("weight_max")
    val maxWeight : Double,
    @SerializedName("lifespan")
    val animalLifespan : Int,
    @SerializedName("habitat")
    val animalHabitat : String,
    @SerializedName("diet")
    val animalDiet : String,
    @SerializedName("geo_range")
    val geoRange : String,
    @SerializedName("image_link")
    val image : String,
    @SerializedName("id")
    val animalId : Int
)