package com.miramicodigo.pokekotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.miramicodigo.pokekotlin.R
import com.miramicodigo.pokekotlin.model.PokemonKt
import kotlinx.android.synthetic.main.item_pokemon.view.*

/**
 * Created by gusn8 on 23-06-17.
 */

class MyKtAdapter(val pokemonList: List<PokemonKt>,
                  val context : Context) :
        RecyclerView.Adapter<MyKtAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
        val name : String = pokemonList[p1].name
        val cp : String = pokemonList[p1].cp
        val photo : Int = pokemonList[p1].photo

        p0!!.tvName.text = name
        p0!!.tvCP.text = cp
        p0!!.ivPhoto.setImageResource(photo)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_pokemon, p0, false))
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tvName : TextView = view.tvItemName
        val tvCP : TextView = view.tvItemCPValue
        val ivPhoto : ImageView = view.ivItemPhoto
    }
}
