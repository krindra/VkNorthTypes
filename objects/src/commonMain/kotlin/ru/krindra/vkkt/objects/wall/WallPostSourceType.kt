package ru.krindra.vkkt.objects.wall

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Type of post source
 * 
 */
@Serializable
enum class WallPostSourceType(val value: String){
    @SerialName("vk") VK("vk"),
    @SerialName("widget") WIDGET("widget"),
    @SerialName("api") API("api"),
    @SerialName("rss") RSS("rss"),
    @SerialName("sms") SMS("sms"),
    @SerialName("mvk") MVK("mvk"),
}
