package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param count 
 * @param items 
 */
@Serializable
data class MessagesMessagesArray (
    @SerialName("items") val items: List<MessagesMessage>? = null,
    @SerialName("count") val count: Int? = null,
)
