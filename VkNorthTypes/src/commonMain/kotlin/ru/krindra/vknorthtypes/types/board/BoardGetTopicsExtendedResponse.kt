package ru.krindra.vknorthtypes.types.board

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersUserFull
import ru.krindra.vknorthtypes.types.groups.GroupsGroupFull
import ru.krindra.vknorthtypes.types.base.BaseBoolInt

/**
 * @param count Total number
 * @param items 
 * @param defaultOrder 
 * @param canAddTopics Information whether current user can add topic
 * @param profiles 
 * @param groups 
 */
@Serializable
data class BoardGetTopicsExtendedResponse (
    @SerialName("count") val count: Int,
    @SerialName("items") val items: List<BoardTopic>,
    @SerialName("groups") val groups: List<GroupsGroupFull>,
    @SerialName("profiles") val profiles: List<UsersUserFull>,
    @SerialName("can_add_topics") val canAddTopics: BaseBoolInt,
    @SerialName("default_order") val defaultOrder: BoardDefaultOrder,
)

