package com.bogotravel.bogotravel.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bogotravel.bogotravel.databinding.FragmentListBinding
import com.bogotravel.bogotravel.model.PoiItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private val listViewModel: listViewModel by viewModels()
    private lateinit var poiAdapter: PoiAdapter
    private var poiList: ArrayList<PoiItem> = arrayListOf()

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
     //   listViewModel.loadMockPoiFromJson(context?.assets?.open("poi.json"))

        listViewModel.getPoiFromServer()

        listViewModel.onPoiLoaded.observe(viewLifecycleOwner, {result ->
            onPoiLoadedSubscribe(result)
        })
        poiAdapter = PoiAdapter(poiList, onItemClicked = { onPoiClicked(it) } )

        listBinding.poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiLoadedSubscribe(result: ArrayList<PoiItem>?) {
        result?.let { poiList ->
            poiAdapter.appendItems(poiList)

        }
    }

    private fun onPoiClicked(poi: PoiItem) {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))
            /*val intent = Intent(this, DetailFragment::class.java)
            intent.putExtra("poi", poi)
            startActivity(intent)*/
        }

}
