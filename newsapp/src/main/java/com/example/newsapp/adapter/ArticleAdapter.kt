package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.newsapp.R
import com.example.newsapp.ui.article.ArticleViewModel
import kotlinx.android.synthetic.main.article_item.view.*

class ArticleAdapter(
    ctx: Context,
    articles: List<ArticleViewModel>
) :
    ArrayAdapter<ArticleViewModel>(ctx, 0, articles) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val article = getItem(position)
        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.article_item,
            parent,
            false
        )
        if (article != null) {
            view.item_image.setImageResource(article.image)
            view.item_text.text = article.title
        }
        return view
    }
}


