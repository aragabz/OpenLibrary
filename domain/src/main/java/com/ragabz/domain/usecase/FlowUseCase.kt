package com.ragabz.domain.usecase

import com.ragabz.core.deliverable.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

abstract class FlowUseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameter: P): Flow<Result<R>> = execute(parameter)
        .catch { e ->
            Timber.e("flowUseCase() --> invoke() --> catch error: ${e}")
            emit(Result.Error(error = Exception(e)))
        }
        .flowOn(dispatcher)

    abstract suspend fun execute(parameter: P): Flow<Result<R>>
}