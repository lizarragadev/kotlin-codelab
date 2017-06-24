package com.miramicodigo.pokekotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.miramicodigo.pokekotlin.adapter.MyKtAdapter
import com.miramicodigo.pokekotlin.model.PokemonKt
import java.util.ArrayList

class MainKtActivity : AppCompatActivity() {

    lateinit var adapter : MyKtAdapter
    lateinit var list : List<PokemonKt>
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
        val po1 : PokemonKt = PokemonKt()
        po1.name = resources.getString(R.string.main_pk1_titulo)
        po1.cp = resources.getString(R.string.main_pk1_subtitulo)

        list = listOf(po1)
    }

}
