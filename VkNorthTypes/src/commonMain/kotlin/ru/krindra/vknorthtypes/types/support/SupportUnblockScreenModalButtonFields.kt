package ru.krindra.vknorthtypes.types.support

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id 
 * @param type 
 * @param label Надпись на кнопке
 * @param modal 
 */
@Serializable
data class SupportUnblockScreenModalButtonFields (
    @SerialName("id") val id: Double? = null,
    @SerialName("label") val label: String? = null,
    @SerialName("type") val type: String,
    @SerialName("modal") val modal: SupportUnblockScreenModalButtonModalContent? = null,
)
