package ru.krindra.vknorthtypes.types.users

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param facebook 
 * @param livejournal 
 * @param twitter 
 */
@Serializable
data class UsersExports (
    @SerialName("twitter") val twitter: Int? = null,
    @SerialName("livejournal") val livejournal: Int? = null,
    @SerialName("facebook") val facebook: Int? = null,
)
