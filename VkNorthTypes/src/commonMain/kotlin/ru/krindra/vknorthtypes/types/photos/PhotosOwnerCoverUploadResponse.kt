package ru.krindra.vknorthtypes.types.photos

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosOwnerCoverUploadResponse (
    val response: PhotosOwnerCoverUploadRawResponse
) {
    /**
     *
     * @param hash Uploading hash
     * @param photo Uploaded photo data
     */
    @Serializable
    data class PhotosOwnerCoverUploadRawResponse (
        @SerialName("hash") val hash: String? = null,
        @SerialName("photo") val photo: String? = null,
    )
}

