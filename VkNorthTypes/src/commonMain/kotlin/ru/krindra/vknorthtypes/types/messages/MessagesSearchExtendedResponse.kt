package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.groups.GroupsGroupFull

import ru.krindra.vknorthtypes.types.users.UsersUserFull


@Serializable
data class MessagesSearchExtendedResponse (
    val response: MessagesSearchExtendedRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     * @param profiles 
     * @param groups 
     * @param conversations 
     */
    @Serializable
    data class MessagesSearchExtendedRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<MessagesMessage>,
        @SerialName("profiles") val profiles: List<UsersUserFull>? = null,
        @SerialName("groups") val groups: List<GroupsGroupFull>? = null,
        @SerialName("conversations") val conversations: List<MessagesConversation>? = null,
    )
}

