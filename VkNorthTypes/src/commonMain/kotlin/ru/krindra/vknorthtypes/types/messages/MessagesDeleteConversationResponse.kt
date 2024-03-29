package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessagesDeleteConversationResponse (
    val response: MessagesDeleteConversationRawResponse
) {
    /**
     *
     * @param lastDeletedId Id of the last message, that was deleted
     */
    @Serializable
    data class MessagesDeleteConversationRawResponse (
        @SerialName("last_deleted_id") val lastDeletedId: Long,
    )
}

