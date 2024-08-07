package ru.krindra.vkkt.responses.bugtracker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.bugtracker.*

/**
 * @param comment 
 * @param commentFlood 
 * @param subscribeState 
 */
@Serializable
data class BugtrackerCreateCommentResponse (
    @SerialName("comment") val comment: BugtrackerComment,
    @SerialName("comment_flood") val commentFlood: Boolean? = null,
    @SerialName("subscribe_state") val subscribeState: BugtrackerBugreportSubscribeState? = null,
)

