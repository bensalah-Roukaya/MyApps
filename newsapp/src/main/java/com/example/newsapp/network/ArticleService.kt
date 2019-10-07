package network

import com.example.newsapp.ui.article.ArticleViewModel
import retrofit2.Call
import retrofit2.http.GET

//Charger une liste d'article
interface ArticleService {

    //GET:requete sur la liste des articles
    @GET("everything?q=bitcoin&from=2019-08-25&sortBy=publishedAt&apiKey=4513f3fb629946dfa1b68114f5f48008")
    fun list(): Call<List<ArticleViewModel>>

}