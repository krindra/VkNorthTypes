package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Reposts
 * 
 * @param count Count
 * @param wallCount Wall count
 * @param mailCount Mail count
 */
@Serializable
data class AdsPostReposts (
    @SerialName("count") val count: Int? = null,
    @SerialName("wall_count") val wallCount: Int? = null,
    @SerialName("mail_count") val mailCount: Int? = null,
)
