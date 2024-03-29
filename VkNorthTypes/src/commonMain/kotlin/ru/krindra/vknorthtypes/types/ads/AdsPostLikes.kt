package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Likes
 * 
 * @param canLike Can like
 * @param count Count
 * @param userLikes User likes
 */
@Serializable
data class AdsPostLikes (
    @SerialName("user_likes") val userLikes: Int? = null,
    @SerialName("can_like") val canLike: Int? = null,
    @SerialName("count") val count: Int? = null,
)
