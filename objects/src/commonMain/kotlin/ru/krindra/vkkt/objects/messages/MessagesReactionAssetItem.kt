package ru.krindra.vkkt.objects.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param reactionId 
 * @param links Liks to reactions assets for each asset type
 */
@Serializable
data class MessagesReactionAssetItem (
    @SerialName("reaction_id") val reactionId: Int,
    @SerialName("links") val links: MessagesReactionAssetItemLinks,
)
