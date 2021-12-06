package com.bogotravel.bogotravel.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogotravel.bogotravel.data.PoiRepository
import com.bogotravel.bogotravel.model.Poi
import com.bogotravel.bogotravel.model.PoiItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class listViewModel : ViewModel() {

    private var poiListLoad: MutableLiveData<ArrayList<PoiItem>> = MutableLiveData()
    val onPoiLoaded: LiveData<ArrayList<PoiItem>> = poiListLoad

    private val repository = PoiRepository()

    fun getPoiFromServer(){
        GlobalScope.launch (Dispatchers.IO){
        poiListLoad.postValue(repository.getPoi())
        }
    }

    fun loadMockPoiFromJson(poiString: InputStream?) {
        val poiString = poiString?.bufferedReader().use {
            it!!.readText() }
            val gson = Gson()
            poiListLoad.value = gson.fromJson(poiString, Poi::class.java)
        }
    }
