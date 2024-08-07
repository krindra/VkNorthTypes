package ru.krindra.vkkt.objects.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Description of the action, that should be performed on button click
 * 
 * @param label Label for button
 * @param link link for button
 * @param payload Additional data sent along with message for developer convenience
 * @param type 
 */
@Serializable
data class MessagesKeyboardButtonActionOpenLink (
    @SerialName("link") val link: String,
    @SerialName("type") val type: String,
    @SerialName("label") val label: String,
    @SerialName("payload") val payload: String? = null,
)
