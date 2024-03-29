package ru.krindra.vknorthtypes.types.base

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param code Error code
 * @param description Error message
 */
@Serializable
data class BaseMessageError (
    @SerialName("code") val code: Int? = null,
    @SerialName("description") val description: String? = null,
)
