package ru.krindra.vkkt.objects.market

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param amount Amount
 * @param amountTo Amount to for price_type=2
 * @param priceType 
 * @param priceUnit 
 * @param currency 
 * @param discountRate 
 * @param oldAmount 
 * @param text Text
 * @param oldAmountText Textual representation of old price
 */
@Serializable
data class MarketPrice (
    @SerialName("text") val text: String,
    @SerialName("amount") val amount: String,
    @SerialName("currency") val currency: MarketCurrency,
    @SerialName("price_type") val priceType: Int? = null,
    @SerialName("price_unit") val priceUnit: Int? = null,
    @SerialName("amount_to") val amountTo: String? = null,
    @SerialName("old_amount") val oldAmount: String? = null,
    @SerialName("discount_rate") val discountRate: Int? = null,
    @SerialName("old_amount_text") val oldAmountText: String? = null,
)
