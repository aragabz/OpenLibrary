package com.ragabz.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Doc(
    @SerializedName("author_alternative_name")
    val authorAlternativeName: List<String>?,
    @SerializedName("author_key")
    val authorKey: List<String>?,
    @SerializedName("author_name")
    val authorName: List<String>?,
    @SerializedName("contributor")
    val contributor: List<String>?,
    @SerializedName("cover_edition_key")
    val coverEditionKey: String?,
    @SerializedName("cover_i")
    val coverI: Int?,
    @SerializedName("ddc")
    val ddc: List<String>?,
    @SerializedName("ebook_count_i")
    val ebookCountI: Int?,
    @SerializedName("edition_count")
    val editionCount: Int?,
    @SerializedName("edition_key")
    val editionKey: List<String>?,
    @SerializedName("first_publish_year")
    val firstPublishYear: Int?,
    @SerializedName("first_sentence")
    val firstSentence: List<String>?,
    @SerializedName("has_fulltext")
    val hasFulltext: Boolean?,
    @SerializedName("ia")
    val ia: List<String>?,
    @SerializedName("ia_box_id")
    val iaBoxId: List<String>?,
    @SerializedName("ia_collection_s")
    val iaCollectionS: String?,
    @SerializedName("ia_loaded_id")
    val iaLoadedId: List<String>?,
    @SerializedName("id_alibris_id")
    val idAlibrisId: List<String>?,
    @SerializedName("id_amazon")
    val idAmazon: List<String>?,
    @SerializedName("id_amazon_ca_asin")
    val idAmazonCaAsin: List<String>?,
    @SerializedName("id_amazon_co_uk_asin")
    val idAmazonCoUkAsin: List<String>?,
    @SerializedName("id_amazon_de_asin")
    val idAmazonDeAsin: List<String>?,
    @SerializedName("id_amazon_it_asin")
    val idAmazonItAsin: List<String>?,
    @SerializedName("id_bcid")
    val idBcid: List<String>?,
    @SerializedName("id_british_national_bibliography")
    val idBritishNationalBibliography: List<String>?,
    @SerializedName("id_canadian_national_library_archive")
    val idCanadianNationalLibraryArchive: List<String>?,
    @SerializedName("id_depósito_legal")
    val idDepósitoLegal: List<String>?,
    @SerializedName("id_goodreads")
    val idGoodreads: List<String>?,
    @SerializedName("id_google")
    val idGoogle: List<String>?,
    @SerializedName("id_librarything")
    val idLibrarything: List<String>?,
    @SerializedName("id_nla")
    val idNla: List<String>?,
    @SerializedName("id_overdrive")
    val idOverdrive: List<String>?,
    @SerializedName("id_paperback_swap")
    val idPaperbackSwap: List<String>?,
    @SerializedName("id_wikidata")
    val idWikidata: List<String>?,
    @SerializedName("isbn")
    val isbn: List<String>?,
    @SerializedName("key")
    val key: String?,
    @SerializedName("language")
    val language: List<String>?,
    @SerializedName("last_modified_i")
    val lastModifiedI: Int?,
    @SerializedName("lcc")
    val lcc: List<String>?,
    @SerializedName("lccn")
    val lccn: List<String>?,
    @SerializedName("lending_edition_s")
    val lendingEditionS: String?,
    @SerializedName("lending_identifier_s")
    val lendingIdentifierS: String?,
    @SerializedName("oclc")
    val oclc: List<String>?,
    @SerializedName("person")
    val person: List<String>?,
    @SerializedName("place")
    val place: List<String>?,
    @SerializedName("printdisabled_s")
    val printdisabledS: String?,
    @SerializedName("public_scan_b")
    val publicScanB: Boolean?,
    @SerializedName("publish_date")
    val publishDate: List<String>?,
    @SerializedName("publish_place")
    val publishPlace: List<String>?,
    @SerializedName("publish_year")
    val publishYear: List<Int>?,
    @SerializedName("publisher")
    val publisher: List<String>?,
    @SerializedName("seed")
    val seed: List<String>?,
    @SerializedName("subject")
    val subject: List<String>?,
    @SerializedName("subtitle")
    val subtitle: String?,
    @SerializedName("text")
    val text: List<String>?,
    @SerializedName("time")
    val time: List<String>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_suggest")
    val titleSuggest: String?,
    @SerializedName("type")
    val type: String?
) : Parcelable