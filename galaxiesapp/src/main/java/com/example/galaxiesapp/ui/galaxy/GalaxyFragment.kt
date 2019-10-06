package com.example.galaxiesapp.ui.galaxy

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.galaxiesapp.R

class GalaxyFragment : Fragment() {

    companion object {
        fun newInstance() = GalaxyFragment()
    }

    private lateinit var viewModel: GalaxyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.galaxy_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(GalaxyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
