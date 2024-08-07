package ru.krindra.vkkt.objects.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Section title
 * 
 */
@Serializable
enum class SearchHintSection(val value: String){
    @SerialName("groups") GROUPS("groups"),
    @SerialName("events") EVENTS("events"),
    @SerialName("publics") PUBLICS("publics"),
    @SerialName("correspondents") CORRESPONDENTS("correspondents"),
    @SerialName("people") PEOPLE("people"),
    @SerialName("friends") FRIENDS("friends"),
    @SerialName("mutual_friends") MUTUAL_FRIENDS("mutual_friends"),
    @SerialName("promo") PROMO("promo"),
}
