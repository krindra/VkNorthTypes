package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param key Long Poll key
 * @param server Long Poll server address
 * @param ts Number of the last event
 */
@Serializable
data class GroupsLongPollServer (
    @SerialName("key") val key: String,
    @SerialName("ts") val ts: String,
    @SerialName("server") val server: String,
)
