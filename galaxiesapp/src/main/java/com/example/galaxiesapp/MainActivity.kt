package com.example.galaxiesapp

import adapters.GalaxyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.galaxiesapp.ui.galaxy.GalaxyFragment
import com.example.galaxiesapp.ui.galaxy.GalaxyViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var galaxyAdapter: GalaxyAdapter
    lateinit var galaxyFragment: GalaxyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        galaxyFragment = GalaxyFragment.newInstance()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, galaxyFragment)
                .commitNow()
        }

        val planetes = resources.getStringArray(R.array.planetes)
        val spinner: Spinner = findViewById(R.id.spinner)

        //instancier l'adapteur 
        var adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            planetes
        )

        var galaxiesList: List<GalaxyViewModel> = listOf(
            GalaxyViewModel("Mercury", "description1", R.drawable.planet_1),
            GalaxyViewModel("Moon", "description2", R.drawable.planet_2),
            GalaxyViewModel("Mars", "description3", R.drawable.planet_3),
            GalaxyViewModel("Earth", "description4", R.drawable.planet_4)
        )

        galaxyAdapter = GalaxyAdapter(this, galaxiesList)

        spinner.adapter = galaxyAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "Vous n'avez rien selectionné", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    baseContext,
                    "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG
                ).show()

            }
        }
    }
}




