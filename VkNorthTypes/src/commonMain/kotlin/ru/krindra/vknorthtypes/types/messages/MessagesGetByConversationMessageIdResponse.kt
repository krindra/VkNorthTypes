package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessagesGetByConversationMessageIdResponse (
    val response: MessagesGetByConversationMessageIdRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class MessagesGetByConversationMessageIdRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<MessagesMessage>,
    )
}

