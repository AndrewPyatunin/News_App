package com.example.newsapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.newsapp.NewsApp
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentDetailNewsBinding
import com.example.newsapp.domain.MyNews
import javax.inject.Inject

class DetailNewsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var binding: FragmentDetailNewsBinding? = null
    private val myNews by lazy { arguments?.getParcelable<MyNews>(NEWS_KEY) }
    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory)[DetailNewsViewModel::class.java] }
    private val component by lazy { (this.requireActivity().application as NewsApp).component.fragmentComponent() }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.getParcelable<NewsFromTopHeadlines>("TopNews")
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailNewsBinding.inflate(inflater, container, false)
        component.inject(this)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        viewModel.getFavouriteNews()
        initViews()
    }

    private fun launchFavouriteNewsFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view_tag, fragment)
            .commit()
    }

    private fun initViews() {
        with(binding!!) {
            textViewDetailDate.text = myNews?.publishedAt
            textViewDetailLink.text = myNews?.url
            textViewDetailTitle.text = myNews?.title
            textViewDetailDescription.text = myNews?.description
            textViewDetailContext.text = myNews?.content?.substringBefore(" [+")
            textViewDetailSource.text = myNews?.sourceName
            Glide.with(this@DetailNewsFragment)
                .load(myNews?.urlToImage)
                .skipMemoryCache(false)
                .into(imageViewDetail)
            imageViewListFavourite.setOnClickListener {
                launchFavouriteNewsFragment(FavouriteNewsFragment.getInstance())
            }
        }
    }

    private fun onClickFavourites(list: List<MyNews>) {
        binding?.imageViewFavourite?.setOnClickListener {
            if (myNews in list) {
                myNews?.let {
                    viewModel.deleteNewsFromFavourite(it)
                }
            } else {
                myNews?.let {
                    viewModel.addNewsToFavourite(it)
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.favouritesLiveData.observe(viewLifecycleOwner) { list ->
            if (myNews in list) {
                binding?.imageViewFavourite?.setImageResource(R.drawable.epiphanybookmarks)
            } else
                binding?.imageViewFavourite?.setImageResource(R.drawable.starempty)
            onClickFavourites(list)
        }
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val NEWS_KEY = "TopNews"

        fun getInstance(news: MyNews): DetailNewsFragment {
            return DetailNewsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(NEWS_KEY, news)
                }
            }
        }
    }
}