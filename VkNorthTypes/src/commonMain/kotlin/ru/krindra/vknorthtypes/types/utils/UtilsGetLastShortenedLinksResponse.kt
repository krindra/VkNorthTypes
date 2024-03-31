package ru.krindra.vknorthtypes.types.utils

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UtilsGetLastShortenedLinksResponse (
    val response: UtilsGetLastShortenedLinksRawResponse
) {
    /**
     *
     * @param count Total number of available results
     * @param items 
     */
    @Serializable
    data class UtilsGetLastShortenedLinksRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<UtilsLastShortenedLink>,
    )
}

