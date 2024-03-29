package ru.krindra.vknorthtypes.types.base

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.market.MarketPrice

/**
 *
 * @param price 
 * @param merchant 
 * @param category 
 * @param geo 
 * @param distance 
 * @param city 
 * @param status 
 * @param ordersCount 
 * @param type 
 */
@Serializable
data class BaseLinkProduct (
    @SerialName("geo") val geo: BaseGeoCoordinates? = null,
    @SerialName("price") val price: MarketPrice,
    @SerialName("merchant") val merchant: String? = null,
    @SerialName("category") val category: BaseLinkProductCategory? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("orders_count") val ordersCount: Int? = null,
    @SerialName("status") val status: BaseLinkProductStatus? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("distance") val distance: Int? = null,
)
