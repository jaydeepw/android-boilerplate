package com.github.jaydeepw.boilerplate.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.jaydeepw.boilerplate.R
import com.github.jaydeepw.boilerplate.contracts.MainContractInterface
import com.github.jaydeepw.pokemondirectory.models.dataclasses.Pokemon
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter(val items : ArrayList<Pokemon>?, val context: Context
              ,var presenter: MainContractInterface.Presenter) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHoldder =  ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false),
            presenter)
        return viewHoldder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = items?.get(position)
        holder.itemView.tag = pokemon
        holder.pokemonTitle.text = pokemon?.name?.capitalize()
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items?.size!!
    }

    fun updateAll(newItems: List<Pokemon>) {
        items?.clear()
        items?.addAll(newItems)
        notifyDataSetChanged()
    }
}

/**
 * Holds the TextView that will add each animal to
 */
class ViewHolder
    (view: View, private var presenter: MainContractInterface.Presenter) : RecyclerView.ViewHolder(view), View.OnClickListener {

    var pokemonTitle : TextView

    init {
        itemView.setOnClickListener(this)
        pokemonTitle = view.textview_pokemon
    }

    override fun onClick(v: View?) {
        presenter.onItemClick(itemView.tag as Pokemon)
    }
}