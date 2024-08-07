package ru.krindra.vkkt.objects.link

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param type Object type
 * @param ownerId Owner ID
 * @param itemId Item ID
 */
@Serializable
data class LinkTargetObject (
    @SerialName("type") val type: String? = null,
    @SerialName("item_id") val itemId: Int? = null,
    @SerialName("owner_id") val ownerId: Int? = null,
)
