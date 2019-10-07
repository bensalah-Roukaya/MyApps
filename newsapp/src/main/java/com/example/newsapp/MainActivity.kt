package com.example.newsapp

import adapters.ArticleAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import com.example.newsapp.ui.article.ArticleFragment
import com.example.newsapp.ui.article.ArticleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import network.ArticleRepository

class MainActivity : AppCompatActivity() {

    lateinit var articleAdapter: ArticleAdapter
    lateinit var repository: ArticleRepository
    var articles: List<ArticleViewModel> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        repository = ArticleRepository()

        //GlobalScope.launch { getData() }


        articles = getLocalData()

        val spinner: Spinner = findViewById(R.id.spinner)

        articleAdapter = ArticleAdapter(this, articles)

        spinner.adapter = articleAdapter

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
                val articleFragment: ArticleFragment = ArticleFragment.newInstance()
                articleFragment.viewModel = articles.get(position)
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, articleFragment)
                        .commitNow()
                }

            }
        }
    }

    //S'execute dans un thread secondeaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result)
        }
    }

    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Any>) {
        withContext(Dispatchers.Main) {
            //afficher les données dans le recycler
            //articles = result
        }
    }

    private fun getLocalData() : List<ArticleViewModel> {
        return listOf(
            ArticleViewModel("Mercure", "Mercure est la planète la plus proche du Soleil et la moins massive du Système solaire1. Son éloignement au Soleil est compris entre 0,31 et 0,47 unité astronomique (46 et 70 millions de kilomètres), ce qui correspond à une excentricité orbitale de 0,2 — plus de douze fois supérieure à celle de la Terre, et de loin la plus élevée pour une planète du système solaire", R.drawable.planet_1),
            ArticleViewModel("Lune", "La Lune, ou Terre I, est un objet céleste qui orbite autour de la planète Terre et le seul satellite naturel permanent de la Terre. C'est le cinquième plus grand satellite naturel du Système solaire et le plus grand des satellites planétaires par rapport à la taille de la planète autour de laquelle elle orbite", R.drawable.planet_2),
            ArticleViewModel("Mars", "Mars est la quatrième planète par ordre de distance croissante au Soleil et la deuxième par masse et par taille croissantes. Son éloignement au Soleil est compris entre 1,381 et 1,666 UA, avec une période orbitale de 669,58 jours martiens.", R.drawable.planet_3),
            ArticleViewModel("Terre", "La Terre est une planète du Système solaire, la troisième plus proche du Soleil et la cinquième plus grande, tant en taille qu'en masse, de ce système planétaire dont elle est également la plus massive des planètes telluriques.", R.drawable.planet_4)
        )
    }
}






