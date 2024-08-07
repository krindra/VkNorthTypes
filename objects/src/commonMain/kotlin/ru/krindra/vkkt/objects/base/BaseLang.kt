package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BaseLang(val value: String){
    @SerialName("ru") RUSSIAN("ru"),
    @SerialName("ua") UKRAINIAN("ua"),
    @SerialName("be") BELARUSIAN("be"),
    @SerialName("en") ENGLISH("en"),
    @SerialName("es") SPANISH("es"),
    @SerialName("fi") FINNISH("fi"),
    @SerialName("de") GERMAN("de"),
    @SerialName("it") ITALIAN("it"),
}
