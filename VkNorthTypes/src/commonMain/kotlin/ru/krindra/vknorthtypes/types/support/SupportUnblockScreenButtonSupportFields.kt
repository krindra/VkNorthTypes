package ru.krindra.vknorthtypes.types.support

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param type 
 * @param id 
 * @param text 
 */
@Serializable
data class SupportUnblockScreenButtonSupportFields (
    @SerialName("id") val id: Double? = null,
    @SerialName("type") val type: String,
    @SerialName("text") val text: String? = null,
)
