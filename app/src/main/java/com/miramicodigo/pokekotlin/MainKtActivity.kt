package com.miramicodigo.pokekotlin

import android.content.res.TypedArray
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.miramicodigo.pokekotlin.adapter.MyKtAdapter
import com.miramicodigo.pokekotlin.model.PokemonKt
import java.util.ArrayList

class MainKtActivity : AppCompatActivity() {

    lateinit var adapter : MyKtAdapter
    lateinit var list : ArrayList<PokemonKt>
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kt)

        recyclerView = findViewById(R.id.rvPokeKotlin) as RecyclerView
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        populateList()

        adapter = MyKtAdapter(list, this)
        recyclerView.adapter = adapter
    }

    fun populateList() {
        var arrayName : Array<String> = resources.getStringArray(R.array.name)
        var arrayCP : Array<String> = resources.getStringArray(R.array.cp)
        var arrayImgs: TypedArray = resources.obtainTypedArray(R.array.photo)

        list = ArrayList<PokemonKt>()

        for (i in arrayName.indices) {
            var poke : PokemonKt = PokemonKt(arrayName[i], arrayCP[i], arrayImgs.getResourceId(i, -1))
            list.add(poke)
        }
    }

}
