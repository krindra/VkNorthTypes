package ru.krindra.vknorthtypes.types.store

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreGetStickersKeywordsResponse (
    val response: StoreGetStickersKeywordsRawResponse
) {
    /**
     *
     * @param count 
     * @param dictionary 
     * @param chunksCount Total count of chunks to load
     * @param chunksHash Chunks version hash
     */
    @Serializable
    data class StoreGetStickersKeywordsRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("dictionary") val dictionary: List<StoreStickersKeyword>,
        @SerialName("chunks_count") val chunksCount: Int? = null,
        @SerialName("chunks_hash") val chunksHash: String? = null,
    )
}

