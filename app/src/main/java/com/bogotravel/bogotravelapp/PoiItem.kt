package com.bogotravel.bogotravelapp


import com.google.gson.annotations.SerializedName

data class PoiItem(
    @SerializedName("descripcorta")
    val descripcorta: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("valoracion")
    val valoracion: String
)