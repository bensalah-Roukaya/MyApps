package network

import com.example.newsapp.ui.article.ArticleViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository {

    private val service: ArticleService

    init {
        val retrofit = Retrofit.Builder().apply {

            baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())

        }.build()

        service = retrofit.create(ArticleService::class.java)
    }


    fun list(): List<ArticleViewModel> {
        val response = service.list().execute()
        return response.body() ?: emptyList()
    }


}