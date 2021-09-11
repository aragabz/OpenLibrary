package com.ragabz.openlibrary.ui.details

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.ragabz.core.base.BaseViewModel
import com.ragabz.model.Doc
import com.ragabz.openlibrary.utils.ImageSize
import com.ragabz.openlibrary.utils.getDocumentCoverImage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DocumentDetailsViewModel @Inject constructor() : BaseViewModel() {

    var document: Doc? = null

    var isbnList = ObservableArrayList<String>()

    var titleObservableField: ObservableField<String> = ObservableField("")
    var authorObservableField: ObservableField<String> = ObservableField("")
    var coverObservableField: ObservableField<String> = ObservableField("")

    fun updateData() {
        titleObservableField.set(document?.title)
        authorObservableField.set(document?.authorName?.first())

        coverObservableField.set(
            getDocumentCoverImage(
                document?.coverI.toString(),
                ImageSize.LARGE
            )
        )

        isbnList.addAll(document?.isbn ?: emptyList())
    }
}
