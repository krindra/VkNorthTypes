package ru.krindra.vknorthtypes.types.market

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarketGetByIdExtendedResponse (
    val response: MarketGetByIdExtendedRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class MarketGetByIdExtendedRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<MarketMarketItemFull>,
    )
}

