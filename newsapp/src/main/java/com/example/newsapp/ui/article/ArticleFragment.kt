package com.example.newsapp.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapp.R

class ArticleFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleFragment()
    }

    lateinit var viewModel: ArticleViewModel

    lateinit var titleView: TextView
    lateinit var descriptionView: TextView
    lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.article_fragment, container, false)
        imageView = view.findViewById(R.id.article_Image) as ImageView
        titleView = view.findViewById(R.id.article_title) as TextView
        descriptionView = view.findViewById(R.id.article_description) as TextView
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        titleView.text = viewModel.title
        descriptionView.text = viewModel.description
        imageView.setImageResource(viewModel.image)
    }

}
