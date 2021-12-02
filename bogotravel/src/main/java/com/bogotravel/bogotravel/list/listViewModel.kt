package com.bogotravel.bogotravel.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogotravel.bogotravel.model.Poi
import com.bogotravel.bogotravel.model.PoiItem
import com.google.gson.Gson
import java.io.InputStream

class listViewModel : ViewModel() {

    private var poiListLoad: MutableLiveData<ArrayList<PoiItem>> = MutableLiveData()
    val onPoiLoaded: LiveData<ArrayList<PoiItem>> = poiListLoad

    fun loadMockPoiFromJson(poiString: InputStream?) {
        val poiString = poiString?.bufferedReader().use {
            it!!.readText() }
            val gson = Gson()
            poiListLoad.value = gson.fromJson(poiString, Poi::class.java)
        }
    }
