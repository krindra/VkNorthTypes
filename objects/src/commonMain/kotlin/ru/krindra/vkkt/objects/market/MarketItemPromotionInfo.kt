package ru.krindra.vkkt.objects.market

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Information about promotion of the market item
 * 
 * @param isAvailable Can the item be promoted?
 */
@Serializable
data class MarketItemPromotionInfo (
    @SerialName("is_available") val isAvailable: Boolean? = null,
)
