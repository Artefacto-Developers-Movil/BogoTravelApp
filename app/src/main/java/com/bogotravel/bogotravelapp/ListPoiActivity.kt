package com.bogotravel.bogotravelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListPoiActivity : AppCompatActivity() {

    private lateinit var listPoi: ArrayList<Poi>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poi)

        poiRecyclerView = findViewById(R.id.poi_recycler_view)

        listPoi = createMockPoi()
        poiAdapter = PoiAdapter(listPoi)

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun createMockPoi(): ArrayList<Poi> {
        /* Crear superheroe uno a uno
        var lista: ArrayList<Poi> = arrayListOf()
         var poi = Poi(
             name = "USAQUÉN",
             description = "Super strength, flight, invulnerability, super speed, heat vision, freeze breath, x-ray vision, superhuman hearing, healing factor",
             valoracion = "Clark Kent, Kal-El",
             image = "usaquenr.jpg",
         )
         lista.add(poi)
         return lista*/

        return arrayListOf(
            Poi(
                name = "Usaquén",
                descripcorta = "Usaquén está ubicada al norte de Bogotá y es un popular paraje para descubrir la ciudad.",
                valoracion = "* * * * *",
                image = "usaquenrec.jpg"
            ),
            Poi(
                name = "Parque Simón Bolivar",
                descripcorta = "Se le considera el “pulmón de la ciudad”, por su estratégica ubicación en el corazón de Bogotá, amplia vegetación y gran dimensión de zonas verdes.",
                valoracion = "* * * *",
                image = "simonbolr.jpg"
            ),
            Poi(
                name = "Monserrate",
                descripcorta = "Monserrate, el cerro que se ha convertido en el lugar imperdible y punto de referencia de la ciudad.",
                valoracion = "* * * * *",
                image = "monserrater.jpg"
            ),
            Poi(
                name = "Planetario",
                descripcorta = "Un lugar mágico que hace del conocimiento una realidad palpable a los sentidos y la imaginación.",
                valoracion = "* * * * *",
                image = "planetarior.jpg"
            ),
            Poi(
                name = "Biblioteca Virgilio Barco",
                descripcorta = "La biblioteca Virgilio Barco es un lugar especial para los que les gusta apreciar el arte de la arquitectura.",
                valoracion = "* * * *",
                image = "bibliotecar.jpg"
            ),
            Poi(
                name = "Jardín Botánico",
                descripcorta = "20 hectáreas enriquecidas con colecciones de plantas vivas científicamente organizadas con especies nativas y exóticas.",
                valoracion = "* * * * *",
                image = "jardinbor.jpg"
            )
        )
    }
}