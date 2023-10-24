package com.example.newsapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.FragmentGlobalNewsBinding


class GlobalNewsFragment : Fragment() {

    private var binding: FragmentGlobalNewsBinding? = null
    private val viewModel by lazy { ViewModelProvider(this)[GlobalNewsViewModel::class.java] }
    private lateinit var adapter: GlobalNewsAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGlobalNewsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNews("https://newsapi.org/v2/top-headlines?country=us&apiKey=$API_KEY")
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.topNewsLiveData.observe(viewLifecycleOwner) {
            binding?.recyclerView?.let {
                recyclerView = it
            }
            recyclerView.layoutManager =
                LinearLayoutManager(this.requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = GlobalNewsAdapter(it.articles)
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(this.requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        private const val API_KEY = "2cd2edc1d12c44978faf4d22ff89b796"
        @JvmStatic
        fun newInstance() = GlobalNewsFragment()
    }
}