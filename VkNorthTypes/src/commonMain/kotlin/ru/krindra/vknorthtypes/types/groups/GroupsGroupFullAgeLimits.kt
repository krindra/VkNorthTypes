package ru.krindra.vknorthtypes.types.groups

import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.EnumAsIntSerializer

private class GroupsGroupFullAgeLimitsSerializer: EnumAsIntSerializer<GroupsGroupFullAgeLimits>(
    "GroupsGroupFullAgeLimits", { it.value }, { v -> GroupsGroupFullAgeLimits.values().first { it.value == v } }
)

@Serializable(with = GroupsGroupFullAgeLimitsSerializer::class)
enum class GroupsGroupFullAgeLimits(val value: Int){
    NO(1),
    OVER_16(2),
    OVER_18(3),
}
