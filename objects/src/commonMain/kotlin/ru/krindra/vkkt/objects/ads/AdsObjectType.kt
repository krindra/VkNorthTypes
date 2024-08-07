package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Object type
 * 
 */
@Serializable
enum class AdsObjectType(val value: String){
    @SerialName("ad") AD("ad"),
    @SerialName("campaign") CAMPAIGN("campaign"),
    @SerialName("client") CLIENT("client"),
    @SerialName("office") OFFICE("office"),
}
