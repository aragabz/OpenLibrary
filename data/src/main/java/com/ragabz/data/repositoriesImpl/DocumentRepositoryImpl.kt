package com.ragabz.data.repositoriesImpl

import com.ragabz.core.deliverable.Result
import com.ragabz.data.extensions.asFlow
import com.ragabz.data.source.remote.DocumentApi
import com.ragabz.domain.repositories.IDocumentRepository
import com.ragabz.model.SearchResponseModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DocumentRepositoryImpl @Inject constructor(
    private val documentApi: DocumentApi
) : IDocumentRepository {

    override suspend fun searchForDocumentByQuery(query: String): Flow<Result<SearchResponseModel>> {
        return documentApi.searchByQuery(query).asFlow()
    }

    override suspend fun searchForDocumentByTitle(title: String): Flow<Result<SearchResponseModel>> {
        return documentApi.searchByTitle(title).asFlow()
    }

    override suspend fun searchForDocumentByAuthor(author: String): Flow<Result<SearchResponseModel>> {
        return documentApi.searchByAuthor(author).asFlow()
    }

    override suspend fun searchForDocumentByQueryWithPaging(
        query: String,
        page: Int
    ): Flow<Result<SearchResponseModel>> {
        return documentApi.searchByQueryWithPaging(query, page).asFlow()
    }
}