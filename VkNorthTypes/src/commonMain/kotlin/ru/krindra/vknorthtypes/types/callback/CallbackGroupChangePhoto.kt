package ru.krindra.vknorthtypes.types.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.photos.PhotosPhoto

/**
 *
 * @param userId 
 * @param photo 
 */
@Serializable
data class CallbackGroupChangePhoto (
    @SerialName("user_id") val userId: Long,
    @SerialName("photo") val photo: PhotosPhoto,
)
