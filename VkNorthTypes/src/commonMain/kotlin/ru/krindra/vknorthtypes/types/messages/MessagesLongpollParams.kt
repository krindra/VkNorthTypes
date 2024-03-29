package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param server Server URL
 * @param key Key
 * @param ts Timestamp
 * @param pts Persistent timestamp
 */
@Serializable
data class MessagesLongpollParams (
    @SerialName("key") val key: String,
    @SerialName("server") val server: String,
    @SerialName("pts") val pts: Int? = null,
    @SerialName("ts") val ts: Int,
)
