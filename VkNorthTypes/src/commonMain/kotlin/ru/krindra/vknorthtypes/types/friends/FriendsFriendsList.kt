package ru.krindra.vknorthtypes.types.friends

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id List ID
 * @param name List title
 */
@Serializable
data class FriendsFriendsList (
    @SerialName("name") val name: String,
    @SerialName("id") val id: Long,
)
