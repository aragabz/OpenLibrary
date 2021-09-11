package com.ragabz.model


import com.google.gson.annotations.SerializedName

data class SearchResponseModel(
    @SerializedName("docs")
    val docs: List<Doc>?,
    @SerializedName("numFound")
    val numFound: Int?,
    @SerializedName("num_found")
    val num_Found: Int?,
    @SerializedName("start")
    val start: Int?
)