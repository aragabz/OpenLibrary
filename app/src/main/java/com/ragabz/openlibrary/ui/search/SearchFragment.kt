package com.ragabz.openlibrary.ui.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ragabz.core.base.BaseDBFragment
import com.ragabz.core.utils.ItemClickSupport
import com.ragabz.openlibrary.ui.NetworkViewModel
import com.ragabz.openlibrary.R
import com.ragabz.openlibrary.databinding.FragmentSearchBinding
import com.ragabz.openlibrary.ui.details.DocumentDetailsFragment
import com.ragabz.openlibrary.ui.details.SearchBY
import com.ragabz.openlibrary.ui.details.SearchOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    BaseDBFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by viewModels()

    val networkViewModel: NetworkViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleGettingBackWithParameter()
    }

    override fun onInitBinding() {
//        binding.fragment = this
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            fragment = this@SearchFragment
            viewModel = this@SearchFragment.viewModel
        }

        // recyclerview item click
        initListItemClick()

        // search QueryText listener
        binding.searchView.isActivated = true
        binding.searchView.clearFocus()
        initSearchAction()
    }

    private fun initListItemClick() {
        ItemClickSupport.addTo(binding.recyclerView)
            .setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
                override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                    // start navigate to details screen
                    val directions =
                        SearchFragmentDirections.actionSearchFragmentToDocumentDetailsFragment(
                            viewModel.documentList[position].document
                        )
                    findNavController().navigate(directions)
                }
            })
    }

    private fun initSearchAction() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if (networkViewModel.isConnected())
                        viewModel.searchWithQuery(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun handleGettingBackWithParameter() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<SearchOptions>(
            DocumentDetailsFragment.SEARCH_FOR
        )?.observe(viewLifecycleOwner) { searchOptions ->
            binding.searchView.setQuery(searchOptions.data, false)
            if (networkViewModel.isConnected()) {
                when (searchOptions.searchBy) {
                    SearchBY.TITLE -> viewModel.searchWithTitle(searchOptions.data)
                    SearchBY.AUTHOR -> viewModel.searchWithAuthor(searchOptions.data)
                }
            }
        }
    }

}
