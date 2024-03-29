package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdsGetLookalikeRequestsResponse (
    val response: AdsGetLookalikeRequestsRawResponse
) {
    /**
     *
     * @param count Total count of found lookalike requests
     * @param items found lookalike requests
     */
    @Serializable
    data class AdsGetLookalikeRequestsRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<AdsLookalikeRequest>,
    )
}

