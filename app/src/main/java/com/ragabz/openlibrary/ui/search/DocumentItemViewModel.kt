package com.ragabz.openlibrary.ui.search

import com.ragabz.model.Doc
import com.ragabz.openlibrary.utils.getDocumentCoverImage

data class DocumentItemViewModel(val document: Doc) {
    val cover: String
        get() = document.coverI?.let { getDocumentCoverImage(it.toString()) } ?: ""

    val title: String get() = document.title ?: "No Title"

    val authorName: String get() = document.authorName?.first() ?: "no author"
}
