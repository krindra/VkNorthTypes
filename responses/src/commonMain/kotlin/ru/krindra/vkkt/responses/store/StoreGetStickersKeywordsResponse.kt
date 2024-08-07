package ru.krindra.vkkt.responses.store

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.store.*

/**
 * @param count 
 * @param dictionary 
 * @param chunksCount Total count of chunks to load
 * @param chunksHash Chunks version hash
 */
@Serializable
data class StoreGetStickersKeywordsResponse (
    @SerialName("count") val count: Int,
    @SerialName("chunks_count") val chunksCount: Int? = null,
    @SerialName("chunks_hash") val chunksHash: String? = null,
    @SerialName("dictionary") val dictionary: List<StoreStickersKeyword>,
)

