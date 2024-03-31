package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param market 
 * @param hasMarketApp Information whether community has installed market app
 * @param usingVkpayMarketApp 
 */
@Serializable
data class GroupsMarketProperties (
    @SerialName("market") val market: GroupsMarketInfo? = null,
    @SerialName("using_vkpay_market_app") val usingVkpayMarketApp: Boolean? = null,
    @SerialName("has_market_app") val hasMarketApp: Boolean? = null,
)
