package ru.krindra.vknorthtypes.types.support

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param type 
 * @param text Текст
 * @param bgImage Полный URL фонового изображения
 */
@Serializable
data class SupportUnblockScreenTextBackgroundFields (
    @SerialName("type") val type: String,
    @SerialName("bg_image") val bgImage: String? = null,
    @SerialName("text") val text: String? = null,
)
