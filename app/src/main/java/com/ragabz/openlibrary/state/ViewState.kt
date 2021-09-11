package com.ragabz.openlibrary.state

interface ViewState

sealed class SearchState : ViewState {
    object Loading : SearchState()
    object Loaded : SearchState()
    object Empty : SearchState()
    object Error : SearchState()

    fun isLoading() = this is Loading
    fun isEmpty() = this is Empty
    fun isError() = this is Error
    fun isLoaded() = this is Loaded
}

