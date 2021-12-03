package com.bogotravel.bogotravel.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bogotravel.bogotravel.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poi = args.poi

        with(detailBinding) {
            tituloView.text = poi.name
            descripcionView.text = poi.descripcion
            temperaturaView.text = poi.temperatura
            com.squareup.picasso.Picasso.get().load(poi.urlPictureBig).into(imageView2)
            mapButton.setOnClickListener {
                val gmmIntentUri = Uri.parse("google.navigation:q="+poi.latitud+","+poi.longitud + "&mode=b")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }

            mapButton.setOnClickListener{
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment())
            }
        }
    }
}