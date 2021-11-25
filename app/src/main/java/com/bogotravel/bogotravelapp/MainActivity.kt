package com.bogotravel.bogotravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bogotravel.bogotravelapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val poi: PoiItem = intent.extras?.getSerializable("poi") as PoiItem
        detalleBinding.tituloView.text = poi.name

        with(detalleBinding){
            tituloView.text = poi.name
            descripcionView.text = poi.descripcion
            temperaturaView.text = poi.temperatura
            Picasso.get().load(poi.urlPicture).into(imageView2)

        }
    }
}