package com.ragabz.core.deliverable

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Exception) : Result<Nothing>()

    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data: $data]"
            is Error -> "Error[error: $error]"
            is Loading -> "Loading..."
        }
    }

}