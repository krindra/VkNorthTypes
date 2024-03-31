package ru.krindra.vknorthtypes.types.photos

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param height Height in px
 * @param url URL of the image
 * @param src URL of the image
 * @param type 
 * @param width Width in px
 */
@Serializable
data class PhotosPhotoSizes (
    @SerialName("src") val src: String? = null,
    @SerialName("height") val height: Int,
    @SerialName("width") val width: Int,
    @SerialName("type") val type: PhotosPhotoSizesType,
    @SerialName("url") val url: String? = null,
)
