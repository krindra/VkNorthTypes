package ru.krindra.vkkt.objects.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AccountCountersFilter(val value: String){
    @SerialName("app_requests") APP_REQUESTS("app_requests"),
    @SerialName("events") EVENTS("events"),
    @SerialName("friends") FRIENDS("friends"),
    @SerialName("friends_recommendations") FRIENDS_RECOMMENDATIONS("friends_recommendations"),
    @SerialName("gifts") GIFTS("gifts"),
    @SerialName("groups") GROUPS("groups"),
    @SerialName("messages") MESSAGES("messages"),
    @SerialName("notes") NOTES("notes"),
    @SerialName("notifications") NOTIFICATIONS("notifications"),
    @SerialName("photos") PHOTOS("photos"),
    @SerialName("faves") FAVES("faves"),
    @SerialName("memories") MEMORIES("memories"),
}
