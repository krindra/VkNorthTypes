package ru.krindra.vknorthtypes.types.downloadedGames

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DownloadedGamesPaidStatusResponse (
    val response: DownloadedGamesPaidStatusRawResponse
) {
    /**
     *
     * @param isPaid Game has been paid
     */
    @Serializable
    data class DownloadedGamesPaidStatusRawResponse (
        @SerialName("is_paid") val isPaid: Boolean,
    )
}

