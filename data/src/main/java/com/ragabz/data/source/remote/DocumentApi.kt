package com.ragabz.data.source.remote

import com.ragabz.model.SearchResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val SEARCH_ENDPOINT = "search.json"
private const val QUERY_PARAM = "q"
private const val TITLE_PARAM = "title"
private const val AUTHOR_PARAM = "author"
private const val PAGE_PARAM = "page"

interface DocumentApi {

    @GET(SEARCH_ENDPOINT)
    suspend fun searchByQuery(@Query(QUERY_PARAM) query: String): Response<SearchResponseModel>

    @GET(SEARCH_ENDPOINT)
    suspend fun searchByTitle(@Query(TITLE_PARAM) title: String): Response<SearchResponseModel>

    @GET(SEARCH_ENDPOINT)
    suspend fun searchByAuthor(@Query(AUTHOR_PARAM) author: String): Response<SearchResponseModel>

    @GET(SEARCH_ENDPOINT)
    suspend fun searchByQueryWithPaging(
        @Query(QUERY_PARAM) query: String,
        @Query(PAGE_PARAM) page: Int
    ): Response<SearchResponseModel>
}