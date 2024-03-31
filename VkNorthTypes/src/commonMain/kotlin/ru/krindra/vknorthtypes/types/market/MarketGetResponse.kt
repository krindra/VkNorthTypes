package ru.krindra.vknorthtypes.types.market

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarketGetResponse (
    val response: MarketGetRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     * @param variants 
     */
    @Serializable
    data class MarketGetRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<MarketMarketItem>,
        @SerialName("variants") val variants: List<MarketMarketItem>? = null,
    )
}

