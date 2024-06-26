package ru.krindra.vknorthtypes.types.groups

import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.EnumAsIntSerializer

/**
 *
 * Level of current user's credentials as manager
 * 
 */
private class GroupsGroupAdminLevelSerializer: EnumAsIntSerializer<GroupsGroupAdminLevel>(
    "GroupsGroupAdminLevel", { it.value }, { v -> GroupsGroupAdminLevel.values().first { it.value == v } }
)

@Serializable(with = GroupsGroupAdminLevelSerializer::class)
enum class GroupsGroupAdminLevel(val value: Int){
    MODERATOR(1),
    EDITOR(2),
    ADMINISTRATOR(3),
}
