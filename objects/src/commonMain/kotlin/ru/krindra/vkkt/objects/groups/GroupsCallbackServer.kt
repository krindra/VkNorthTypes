package ru.krindra.vkkt.objects.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id 
 * @param title 
 * @param creatorId 
 * @param url 
 * @param secretKey 
 * @param status 
 */
@Serializable
data class GroupsCallbackServer (
    @SerialName("id") val id: Int,
    @SerialName("url") val url: String,
    @SerialName("title") val title: String,
    @SerialName("status") val status: String,
    @SerialName("creator_id") val creatorId: Int,
    @SerialName("secret_key") val secretKey: String,
)
