package ru.krindra.vkkt.objects.video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseBoolInt

/**
 *
 * Video live settings
 * 
 * @param canRewind If user car rewind live or not
 * @param isEndless If live is endless or not
 * @param maxDuration Max possible time for rewind
 * @param isClipsLive If live in clips apps
 */
@Serializable
data class VideoLiveSettings (
    @SerialName("max_duration") val maxDuration: Int? = null,
    @SerialName("can_rewind") val canRewind: BaseBoolInt? = null,
    @SerialName("is_endless") val isEndless: BaseBoolInt? = null,
    @SerialName("is_clips_live") val isClipsLive: BaseBoolInt? = null,
)
