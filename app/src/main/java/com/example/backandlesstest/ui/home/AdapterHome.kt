package com.example.backandlesstest.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.backandlesstest.R
import com.example.backandlesstest.databinding.CellActorBinding
import com.example.backandlesstest.domain.models.ActorModel

class AdapterHome : RecyclerView.Adapter<AdapterHome.HomeViewHolder>() {

    private val actorsList = mutableListOf<ActorModel>()

    private lateinit var onActorItemClickListener: OnActorItemClickListener

    fun setUpAdapterData(newActorList: List<ActorModel>) {
        actorsList.clear()
        actorsList.addAll(newActorList)
        notifyDataSetChanged()
    }

    fun onItemClick(onActorItemClickListener: OnActorItemClickListener) {
        this.onActorItemClickListener = onActorItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val actorBinding: CellActorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cell_actor,
            parent,
            false
        )
        return HomeViewHolder(actorBinding, onActorItemClickListener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val actor = actorsList[position]
        holder.bind(actor)
        holder.onClick(actor.objectId)
    }

    override fun getItemCount(): Int {
        return actorsList.size
    }

    class HomeViewHolder(
        actor: CellActorBinding,
        private val onActorItemClickListener: OnActorItemClickListener
    ) : RecyclerView.ViewHolder(actor.root) {

        private val actorBinding = actor

        fun bind(actor: ActorModel) {
            actorBinding.actorModel = actor
        }

        fun onClick(actorId: String) {
            itemView.setOnClickListener {
                onActorItemClickListener.getActorId(actorId)
            }
        }

    }

    interface OnActorItemClickListener{
        fun getActorId(actorId:String)
    }
}