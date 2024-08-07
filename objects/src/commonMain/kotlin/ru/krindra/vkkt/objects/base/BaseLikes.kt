package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param count Likes number
 * @param userLikes Information whether current user likes the photo
 */
@Serializable
data class BaseLikes (
    @SerialName("count") val count: Int? = null,
    @SerialName("user_likes") val userLikes: BaseBoolInt? = null,
)
