package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param count 
 * @param memberIds 
 */
@Serializable
data class MessagesOutReadBy (
    @SerialName("member_ids") val memberIds: List<Int>? = null,
    @SerialName("count") val count: Int? = null,
)
