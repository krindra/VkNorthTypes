package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Button style
 * 
 */
@Serializable
enum class BaseLinkButtonStyle(val value: String){
    @SerialName("primary") PRIMARY("primary"),
    @SerialName("secondary") SECONDARY("secondary"),
}
