package ru.krindra.vkkt.objects.groups

import kotlinx.serialization.Serializable
import ru.krindra.vkkt.utils.EnumAsIntSerializer

private class GroupsGroupFullMemberStatusSerializer: EnumAsIntSerializer<GroupsGroupFullMemberStatus>(
    "GroupsGroupFullMemberStatus", { it.value }, { v -> GroupsGroupFullMemberStatus.values().first { it.value == v } }
)

@Serializable(with = GroupsGroupFullMemberStatusSerializer::class)
enum class GroupsGroupFullMemberStatus(val value: Int){
    NOT_A_MEMBER(0),
    MEMBER(1),
    NOT_SURE(2),
    DECLINED(3),
    HAS_SENT_A_REQUEST(4),
    INVITED(5),
}
