package ru.krindra.vkkt.objects.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id group ID
 * @param text text of attach
 * @param status activity or category of group
 * @param size size of group
 * @param isFavorite is favorite
 */
@Serializable
data class GroupsGroupAttach (
    @SerialName("id") val id: Int,
    @SerialName("size") val size: Int,
    @SerialName("text") val text: String,
    @SerialName("status") val status: String,
    @SerialName("is_favorite") val isFavorite: Boolean,
)
