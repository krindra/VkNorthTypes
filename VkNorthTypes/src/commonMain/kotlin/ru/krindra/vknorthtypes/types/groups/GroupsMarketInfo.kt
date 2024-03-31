package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseBoolInt
import ru.krindra.vknorthtypes.types.market.MarketCurrency
import ru.krindra.vknorthtypes.types.market.MarketPrice

/**
 *
 * @param type Market type
 * @param contactId Contact person ID
 * @param currency 
 * @param currencyText Currency name
 * @param isShowHeaderItemsLink Shop header items link is enabled
 * @param enabled Information whether the market is enabled
 * @param mainAlbumId Main market album ID
 * @param priceMax Maximum price
 * @param priceMin Minimum price
 * @param minOrderPrice 
 */
@Serializable
data class GroupsMarketInfo (
    @SerialName("currency_text") val currencyText: String? = null,
    @SerialName("main_album_id") val mainAlbumId: Long? = null,
    @SerialName("enabled") val enabled: BaseBoolInt? = null,
    @SerialName("price_max") val priceMax: String? = null,
    @SerialName("price_min") val priceMin: String? = null,
    @SerialName("currency") val currency: MarketCurrency? = null,
    @SerialName("is_show_header_items_link") val isShowHeaderItemsLink: BaseBoolInt? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("contact_id") val contactId: Long? = null,
    @SerialName("min_order_price") val minOrderPrice: MarketPrice? = null,
)
