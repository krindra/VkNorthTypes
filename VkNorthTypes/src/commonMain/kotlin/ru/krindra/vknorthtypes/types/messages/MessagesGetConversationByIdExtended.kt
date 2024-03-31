package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersUserFull
import ru.krindra.vknorthtypes.types.groups.GroupsGroupFull

/**
 *
 * @param profiles 
 * @param groups 
 * @param count Total number
 * @param items 
 */
@Serializable
data class MessagesGetConversationByIdExtended (
    @SerialName("profiles") val profiles: List<UsersUserFull>? = null,
    @SerialName("items") val items: List<MessagesConversation>,
    @SerialName("count") val count: Int,
    @SerialName("groups") val groups: List<GroupsGroupFull>? = null,
)
