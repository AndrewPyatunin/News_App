package com.example.newsapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.NewsApp
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentFavouriteNewsBinding
import javax.inject.Inject

class FavouriteNewsFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var binding: FragmentFavouriteNewsBinding? = null
    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[FavouriteNewsViewModel::class.java] }
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GlobalNewsAdapter
    private val component by lazy { (this.requireActivity().application as NewsApp).component.fragmentComponent() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteNewsBinding.inflate(inflater, container, false)
        component.inject(this)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding?.recyclerViewFavourite!!
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.listFavouriteLiveData.observe(viewLifecycleOwner) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = GlobalNewsAdapter(it)
            adapter = recyclerView.adapter as GlobalNewsAdapter
            adapter.onItemClick = {
                launchDetailNewsFragment(DetailNewsFragment.getInstance(it))
            }
        }
    }

    private fun launchDetailNewsFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view_tag, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        fun getInstance(): FavouriteNewsFragment {
            return FavouriteNewsFragment()
        }
    }
}