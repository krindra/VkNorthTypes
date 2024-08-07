package ru.krindra.vkkt.objects.market

import kotlinx.serialization.Serializable
import ru.krindra.vkkt.utils.EnumAsIntSerializer

/**
 *
 * Type of view. 1 - cards, 2 - rows
 * 
 */
private class MarketServicesViewTypeSerializer: EnumAsIntSerializer<MarketServicesViewType>(
    "MarketServicesViewType", { it.value }, { v -> MarketServicesViewType.values().first { it.value == v } }
)

@Serializable(with = MarketServicesViewTypeSerializer::class)
enum class MarketServicesViewType(val value: Int){
    CARDS(1),
    ROWS(2),
}
