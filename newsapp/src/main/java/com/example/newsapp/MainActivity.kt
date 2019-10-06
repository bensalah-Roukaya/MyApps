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

class MainActivity : AppCompatActivity() {

    lateinit var articleAdapter: ArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val spinner: Spinner = findViewById(R.id.spinner)

        val articles: List<ArticleViewModel> = listOf(
            ArticleViewModel("Mercury", "description1", R.drawable.planet_1),
            ArticleViewModel("Moon", "description2", R.drawable.planet_2),
            ArticleViewModel("Mars", "description3", R.drawable.planet_3),
            ArticleViewModel("Earth", "description4", R.drawable.planet_4)
        )

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
}




