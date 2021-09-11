package com.ragabz.openlibrary.ui.details

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ragabz.core.base.BaseDBFragment
import com.ragabz.openlibrary.utils.SpacesItemDecoration
import com.ragabz.model.Doc
import com.ragabz.openlibrary.R
import com.ragabz.openlibrary.databinding.FragmentDocumentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize
import timber.log.Timber

@AndroidEntryPoint
class DocumentDetailsFragment :
    BaseDBFragment<FragmentDocumentDetailsBinding, DocumentDetailsViewModel>(
        R.layout.fragment_document_details
    ) {
    companion object {
        const val SEARCH_FOR = "searchFor"
    }

    override val viewModel: DocumentDetailsViewModel by viewModels()

    override fun onInitBinding() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            fragment = this@DocumentDetailsFragment
            viewModel = this@DocumentDetailsFragment.viewModel
        }

        binding.recyclerView.addItemDecoration(SpacesItemDecoration(8))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle == null) {
            Timber.e("DocumentDetailsFragment did not receive document")
            return
        }
        // val args = DocumentDetailsArgs.fromBundle(bundle)
        viewModel.document = bundle.getParcelable("document") as Doc?
        viewModel.updateData()

    }

    fun searchWithTitle() {
        val searchOptions = SearchOptions(viewModel.document?.title ?: "", SearchBY.TITLE)
        navigateToSearch(searchOptions)
    }

    fun searchWithAuthor() {
        val searchOptions =
            SearchOptions(viewModel.document?.authorName?.first() ?: "", SearchBY.AUTHOR)
        navigateToSearch(searchOptions)
    }

    private fun navigateToSearch(searchOptions: SearchOptions) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(
            SEARCH_FOR, searchOptions
        )
        findNavController().popBackStack()
    }

    fun onBackPressed() {
        findNavController().popBackStack()
    }
}

@Parcelize
data class SearchOptions(val data: String, val searchBy: SearchBY) : Parcelable

enum class SearchBY {
    TITLE, AUTHOR
}