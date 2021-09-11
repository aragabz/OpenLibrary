package com.ragabz.openlibrary.utils

const val COVER_URL = "https://covers.openlibrary.org/b"

enum class ImageSize(private val value: String) {
    SMALL("S"), MEDIUM("M"), LARGE("l");

    fun getSize(): String {
        return this.value
    }
}

fun getDocumentCoverImage(value: String, imageSize: ImageSize = ImageSize.SMALL) =
    "$COVER_URL/id/${value}-${imageSize.getSize()}.jpg"

fun getIsbnImage(value: String) = "$COVER_URL/isbn/${value}-M.jpg"