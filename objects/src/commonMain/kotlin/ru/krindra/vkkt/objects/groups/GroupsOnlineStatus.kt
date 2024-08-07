package ru.krindra.vkkt.objects.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Online status of group
 * 
 * @param minutes Estimated time of answer (for status = answer_mark)
 * @param status 
 */
@Serializable
data class GroupsOnlineStatus (
    @SerialName("minutes") val minutes: Int? = null,
    @SerialName("status") val status: GroupsOnlineStatusType,
)
