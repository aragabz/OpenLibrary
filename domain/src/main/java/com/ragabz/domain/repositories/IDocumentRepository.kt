package com.ragabz.domain.repositories

import com.ragabz.core.deliverable.Result
import com.ragabz.model.SearchResponseModel
import kotlinx.coroutines.flow.Flow

interface IDocumentRepository {

    suspend fun searchForDocumentByQuery(query: String): Flow<Result<SearchResponseModel>>

    suspend fun searchForDocumentByTitle(title: String): Flow<Result<SearchResponseModel>>

    suspend fun searchForDocumentByAuthor(author: String): Flow<Result<SearchResponseModel>>

    suspend fun searchForDocumentByQueryWithPaging(
        query: String,
        page: Int
    ): Flow<Result<SearchResponseModel>>
}