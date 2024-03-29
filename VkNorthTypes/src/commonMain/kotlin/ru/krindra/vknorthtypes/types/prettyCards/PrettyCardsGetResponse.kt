package ru.krindra.vknorthtypes.types.prettyCards

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrettyCardsGetResponse (
    val response: PrettyCardsGetRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class PrettyCardsGetRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<PrettyCardsPrettyCard>,
    )
}

