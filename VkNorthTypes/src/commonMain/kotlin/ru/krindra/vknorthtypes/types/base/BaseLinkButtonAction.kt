package ru.krindra.vknorthtypes.types.base

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param type 
 * @param url Action URL
 * @param consumeReason 
 */
@Serializable
data class BaseLinkButtonAction (
    @SerialName("consume_reason") val consumeReason: String? = null,
    @SerialName("type") val type: BaseLinkButtonActionType,
    @SerialName("url") val url: String? = null,
)
