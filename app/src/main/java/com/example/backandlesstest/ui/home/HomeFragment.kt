package com.example.backandlesstest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.backandlesstest.App
import com.example.backandlesstest.R
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var homeFactory: HomeFactory
    lateinit var homeViewModel: HomeViewModel

    lateinit var recyuclerview: RecyclerView
    lateinit var adapter: AdapterHome

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.applicationContext as App).actorComponent.inject(this)

        homeViewModel = ViewModelProvider(this, homeFactory).get(HomeViewModel::class.java)

        recyuclerview = view.findViewById(R.id.rv_actors)

        adapter = AdapterHome()

        recyuclerview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        recyuclerview.adapter = adapter

        navController = Navigation.findNavController(view)

        setUpActorData()
        onChosenActor()

    }

    private fun setUpActorData() {
        homeViewModel.actorsDataList.observe(viewLifecycleOwner, Observer {
            adapter.setUpAdapterData(it)
        })
    }

    private fun onChosenActor() {
        adapter.onItemClick(object : AdapterHome.OnActorItemClickListener {
            override fun getActorId(actorId: String) {
                homeViewModel.chosenActor(actorId)
                switchFragment()
            }
        })
    }

    private fun switchFragment() {
        navController.navigate(R.id.action_homeFragment_to_actorInfoFragment)
    }

}