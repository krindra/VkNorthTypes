package ru.krindra.vkkt.objects.support

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param type 
 * @param text Текст
 * @param notifyBtn Нужна ли кнопка 'Получить уведомление'
 */
@Serializable
data class SupportUnblockScreenTextBorderedFields (
    @SerialName("type") val type: String,
    @SerialName("text") val text: String? = null,
    @SerialName("notify_btn") val notifyBtn: Boolean? = null,
)
