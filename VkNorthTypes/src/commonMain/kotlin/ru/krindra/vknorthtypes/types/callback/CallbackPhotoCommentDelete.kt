package ru.krindra.vknorthtypes.types.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id 
 * @param ownerId 
 * @param userId 
 * @param photoId 
 */
@Serializable
data class CallbackPhotoCommentDelete (
    @SerialName("id") val id: Long,
    @SerialName("user_id") val userId: Long,
    @SerialName("owner_id") val ownerId: Long,
    @SerialName("photo_id") val photoId: Long,
)
