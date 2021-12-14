package com.bogotravel.bogotravel.data

import com.bogotravel.bogotravel.model.Poi
import retrofit2.http.GET

interface ApiService {

    @GET("Artefacto-Developers-Movil/BogoTravelApp/poi")
    suspend fun getPoi(): Poi
}