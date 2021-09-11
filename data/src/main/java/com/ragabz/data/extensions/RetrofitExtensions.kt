package com.ragabz.data.extensions

import com.ragabz.core.deliverable.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import timber.log.Timber

fun <T> Response<T>.asFlow() = flow {
    if (isSuccessful) {
        Timber.i("asFlow() --> isSuccessful")
        emit(Result.Success(body() as T))
    } else {
        Timber.i("asFlow() --> onError(): erroBody --> ${errorBody()} ")
        Timber.i("asFlow() --> onError(): message --> ${message()} ")

        emit(Result.Error(Exception(message())))
    }
}.catch { e ->
    Timber.e("catchError()--> error: ${e}")
    emit(Result.Error(Exception(e)))
}
