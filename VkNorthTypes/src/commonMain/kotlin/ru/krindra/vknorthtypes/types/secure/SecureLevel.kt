package ru.krindra.vknorthtypes.types.secure

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param level Level
 * @param uid User ID
 */
@Serializable
data class SecureLevel (
    @SerialName("uid") val uid: Long? = null,
    @SerialName("level") val level: Int? = null,
)
