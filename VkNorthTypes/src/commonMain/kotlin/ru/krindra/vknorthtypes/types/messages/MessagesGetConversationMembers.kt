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
 * @param items 
 * @param count Chat members count
 * @param chatRestrictions 
 * @param profiles 
 * @param groups 
 */
@Serializable
data class MessagesGetConversationMembers (
    @SerialName("groups") val groups: List<GroupsGroupFull>? = null,
    @SerialName("items") val items: List<MessagesConversationMember>,
    @SerialName("profiles") val profiles: List<UsersUserFull>? = null,
    @SerialName("chat_restrictions") val chatRestrictions: MessagesChatRestrictions? = null,
    @SerialName("count") val count: Int,
)
