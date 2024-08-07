package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param stickerId Sticker ID
 * @param productId Pack ID
 * @param images 
 * @param imagesWithBackground 
 * @param animationUrl URL of sticker animation script
 * @param animations Array of sticker animation script objects
 * @param isAllowed Information whether the sticker is allowed
 */
@Serializable
data class BaseStickerNew (
    @SerialName("product_id") val productId: Int? = null,
    @SerialName("sticker_id") val stickerId: Int? = null,
    @SerialName("is_allowed") val isAllowed: Boolean? = null,
    @SerialName("images") val images: List<BaseImage>? = null,
    @SerialName("animation_url") val animationUrl: String? = null,
    @SerialName("animations") val animations: List<BaseStickerAnimation>? = null,
    @SerialName("images_with_background") val imagesWithBackground: List<BaseImage>? = null,
)
