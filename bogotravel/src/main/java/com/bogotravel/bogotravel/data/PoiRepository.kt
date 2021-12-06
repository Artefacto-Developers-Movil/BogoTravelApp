package com.bogotravel.bogotravel.data

class PoiRepository {

    suspend fun getPoi() = ApiFactory.retrofit.getPoi()

}