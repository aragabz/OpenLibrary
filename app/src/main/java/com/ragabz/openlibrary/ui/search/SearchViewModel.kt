package com.ragabz.openlibrary.ui.search

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ragabz.core.base.BaseViewModel
import com.ragabz.core.deliverable.Result
import com.ragabz.domain.usecase.SearchForDocumentByQueryUseCase
import com.ragabz.model.SearchResponseModel
import com.ragabz.openlibrary.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import sa.com.stc.core.livedata.SingleLiveData
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchForDocumentByQueryUseCase: SearchForDocumentByQueryUseCase,
) : BaseViewModel() {

    // document observable array list to be used to notify data change to dataBinding
    var documentList = ObservableArrayList<DocumentItemViewModel>()

    private val _searchState: MutableLiveData<SearchState> = SingleLiveData<SearchState>()
    var searchState: LiveData<SearchState> = _searchState

    fun searchWithQuery(query: String) {
        _searchState.value = SearchState.Loading
        viewModelScope.launch {
            searchForDocumentByQueryUseCase.invoke(query)
                .collect { handleSearchResult(it) }
        }
    }

    fun searchWithTitle(title: String) {
        _searchState.value = SearchState.Loading
        viewModelScope.launch {
            searchForDocumentByQueryUseCase.invoke(title)
                .collect { handleSearchResult(it) }
        }
    }

    fun searchWithAuthor(author: String) {
        _searchState.value = SearchState.Loading
        viewModelScope.launch {
            searchForDocumentByQueryUseCase.invoke(author)
                .collect { handleSearchResult(it) }
        }
    }

    private fun handleSearchResult(result: Result<SearchResponseModel>) {
        when (result) {
            is Result.Success -> {
                val docList: List<DocumentItemViewModel>? =
                    result.data.docs?.take(100)?.map { DocumentItemViewModel(it) }

                docList?.let {
                    documentList.clear()
                    documentList.addAll(it)
                }
                _searchState.value = SearchState.Loaded
            }
        }
    }
}