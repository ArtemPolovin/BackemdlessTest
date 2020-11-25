package com.example.backandlesstest.ui.actorinfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.backandlesstest.App
import com.example.backandlesstest.R
import com.example.backandlesstest.databinding.ActorInfoFragmentBinding

import javax.inject.Inject

class ActorInfoFragment : Fragment() {

    @Inject
    lateinit var actorInfoFactory: ActorInfoFactory
    lateinit var actorInfoViewModel: ActorInfoViewModel

    private lateinit var actorDataBinding: ActorInfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        actorDataBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.actor_info_fragment, container, false
        )

        return actorDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.applicationContext as App).actorComponent.inject(this)

        actorInfoViewModel =
            ViewModelProvider(this, actorInfoFactory).get(ActorInfoViewModel::class.java)

        setUpUI()

    }

    private fun setUpUI() {
        actorInfoViewModel.actorData.observe(viewLifecycleOwner, Observer{
            Log.i("AAAAAAAAAA", "name = ${it.name}; age = ${it.toString()}")
            actorDataBinding.actor = it
        })
    }

}