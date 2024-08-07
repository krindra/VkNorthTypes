package ru.krindra.vkkt.objects.groups

import kotlinx.serialization.Serializable
import ru.krindra.vkkt.utils.EnumAsIntSerializer

/**
 *
 * Ban reason
 * 
 */
private class GroupsBanInfoReasonSerializer: EnumAsIntSerializer<GroupsBanInfoReason>(
    "GroupsBanInfoReason", { it.value }, { v -> GroupsBanInfoReason.values().first { it.value == v } }
)

@Serializable(with = GroupsBanInfoReasonSerializer::class)
enum class GroupsBanInfoReason(val value: Int){
    OTHER(0),
    SPAM(1),
    VERBAL_ABUSE(2),
    STRONG_LANGUAGE(3),
    FLOOD(4),
}
