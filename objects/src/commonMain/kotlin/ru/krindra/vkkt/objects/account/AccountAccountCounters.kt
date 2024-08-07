package ru.krindra.vkkt.objects.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param appRequests New app requests number
 * @param events New events number
 * @param faves New faves number
 * @param friends New friends requests number
 * @param friendsRecommendations New friends recommendations number
 * @param gifts New gifts number
 * @param groups New groups number
 * @param messages New messages number
 * @param memories New memories number
 * @param notes New notes number
 * @param notifications New notifications number
 * @param photos New photo tags number
 */
@Serializable
data class AccountAccountCounters (
    @SerialName("faves") val faves: Int? = null,
    @SerialName("gifts") val gifts: Int? = null,
    @SerialName("notes") val notes: Int? = null,
    @SerialName("events") val events: Int? = null,
    @SerialName("groups") val groups: Int? = null,
    @SerialName("photos") val photos: Int? = null,
    @SerialName("friends") val friends: Int? = null,
    @SerialName("memories") val memories: Int? = null,
    @SerialName("messages") val messages: Int? = null,
    @SerialName("app_requests") val appRequests: Int? = null,
    @SerialName("notifications") val notifications: Int? = null,
    @SerialName("friends_recommendations") val friendsRecommendations: Int? = null,
)
