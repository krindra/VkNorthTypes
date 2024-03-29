package ru.krindra.vknorthtypes.types.market

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarketGetExtendedResponse (
    val response: MarketGetExtendedRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     * @param variants 
     */
    @Serializable
    data class MarketGetExtendedRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<MarketMarketItemFull>,
        @SerialName("variants") val variants: List<MarketMarketItemFull>? = null,
    )
}

