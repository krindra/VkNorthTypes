package ru.krindra.vknorthtypes.types.market

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.groups.GroupsGroupFull


@Serializable
data class MarketSearchResponse (
    val response: MarketSearchRawResponse
) {
    /**
     *
     * @param count Total number
     * @param viewType 
     * @param items 
     * @param variants 
     * @param groups 
     * @param filters 
     */
    @Serializable
    data class MarketSearchRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("view_type") val viewType: MarketServicesViewType,
        @SerialName("items") val items: List<MarketMarketItem>,
        @SerialName("variants") val variants: List<MarketMarketItem>? = null,
        @SerialName("groups") val groups: List<GroupsGroupFull>? = null,
        @SerialName("filters") val filters: MarketGlobalSearchFilters? = null,
    )
}

