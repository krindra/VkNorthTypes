package ru.krindra.vknorthtypes.types.pages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.Serializable

typealias PagesGetHistoryRawResponse = List<PagesWikipageHistory>
@Serializable
data class PagesGetHistoryResponse (
    val response: PagesGetHistoryRawResponse
)

