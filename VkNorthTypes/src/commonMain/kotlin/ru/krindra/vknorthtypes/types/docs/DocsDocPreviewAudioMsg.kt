package ru.krindra.vknorthtypes.types.docs

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param duration Audio message duration in seconds
 * @param linkMp3 MP3 file URL
 * @param linkOgg OGG file URL
 * @param waveform 
 */
@Serializable
data class DocsDocPreviewAudioMsg (
    @SerialName("link_ogg") val linkOgg: String,
    @SerialName("link_mp3") val linkMp3: String,
    @SerialName("duration") val duration: Int,
    @SerialName("waveform") val waveform: List<Int>,
)
