package ru.krindra.vkkt.objects.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param userId 
 * @param amount 
 * @param amountWithoutFee 
 */
@Serializable
data class CallbackDonutSubscriptionProlonged (
    @SerialName("amount") val amount: Int,
    @SerialName("user_id") val userId: Int? = null,
    @SerialName("amount_without_fee") val amountWithoutFee: Double,
)
