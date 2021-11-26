package com.bogotravel.bogotravel.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bogotravel.bogotravel.databinding.FragmentListBinding
import com.bogotravel.bogotravel.model.Poi
import com.bogotravel.bogotravel.model.PoiItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiList: ArrayList<PoiItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //(activity as MainActivity?)?.hideIcon()
        poiList = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(poiList, onItemClicked = { onPoiClicked(it) } )
        listBinding.poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

        private fun onPoiClicked(poi: PoiItem) {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))
            /*val intent = Intent(this, DetailFragment::class.java)
            intent.putExtra("poi", poi)
            startActivity(intent)*/
        }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem> {
        val poiString: String =
            context?.assets?.open("poi.json")?.bufferedReader().use { it!!.readText() } //reparar
        val gson = Gson()
        return gson.fromJson(poiString, Poi::class.java)
    }

}
