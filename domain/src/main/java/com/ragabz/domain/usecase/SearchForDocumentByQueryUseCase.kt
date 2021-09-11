package com.ragabz.domain.usecase

import com.ragabz.core.deliverable.Result
import com.ragabz.domain.di.IODispatcher
import com.ragabz.domain.repositories.IDocumentRepository
import com.ragabz.model.SearchResponseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchForDocumentByQueryUseCase @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,

    val documentRepository: IDocumentRepository

) : FlowUseCase<String, SearchResponseModel>(dispatcher) {
    override suspend fun execute(parameter: String): Flow<Result<SearchResponseModel>> {
        return documentRepository.searchForDocumentByQuery(parameter)
    }
}