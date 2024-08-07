package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Campaign type
 * 
 */
@Serializable
enum class AdsCampaignType(val value: String){
    @SerialName("normal") NORMAL("normal"),
    @SerialName("vk_apps_managed") VK_APPS_MANAGED("vk_apps_managed"),
    @SerialName("mobile_apps") MOBILE_APPS("mobile_apps"),
    @SerialName("promoted_posts") PROMOTED_POSTS("promoted_posts"),
    @SerialName("adaptive_ads") ADAPTIVE_ADS("adaptive_ads"),
    @SerialName("stories") STORIES("stories"),
}
