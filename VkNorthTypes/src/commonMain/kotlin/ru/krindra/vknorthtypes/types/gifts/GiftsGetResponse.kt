package ru.krindra.vknorthtypes.types.gifts

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GiftsGetResponse (
    val response: GiftsGetRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class GiftsGetRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<GiftsGift>,
    )
}

