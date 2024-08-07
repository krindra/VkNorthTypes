package ru.krindra.vkkt.objects.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Attachments type
 * 
 */
@Serializable
enum class MessagesHistoryMessageAttachmentType(val value: String){
    @SerialName("photo") PHOTO("photo"),
    @SerialName("video") VIDEO("video"),
    @SerialName("audio") AUDIO("audio"),
    @SerialName("doc") DOC("doc"),
    @SerialName("link") LINK("link"),
    @SerialName("market") MARKET("market"),
    @SerialName("wall") WALL("wall"),
    @SerialName("share") SHARE("share"),
    @SerialName("app_action") APP_ACTION("app_action"),
    @SerialName("graffiti") GRAFFITI("graffiti"),
    @SerialName("audio_message") AUDIO_MESSAGE("audio_message"),
}
