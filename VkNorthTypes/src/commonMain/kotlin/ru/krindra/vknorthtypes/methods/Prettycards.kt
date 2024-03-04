package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.prettyCards.*
import kotlinx.serialization.json.Json

class Prettycards(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param ownerId 
     * @param photo 
     * @param title 
     * @param link 
     * @param price 
     * @param priceOld 
     * @param button 
     */
    suspend fun create(ownerId: Long, photo: String, title: String, link: String, price: String? = null, priceOld: String? = null, button: String? = null): PrettyCardsCreateResponse {
        val response = method("create", mapOf("owner_id" to ownerId, "photo" to photo, "title" to title, "link" to link, "price" to price, "price_old" to priceOld, "button" to button))
        return json.decodeFromString<PrettyCardsCreateResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param cardId 
     */
    suspend fun delete(ownerId: Long, cardId: Long): PrettyCardsDeleteResponse {
        val response = method("delete", mapOf("owner_id" to ownerId, "card_id" to cardId))
        return json.decodeFromString<PrettyCardsDeleteResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param cardId 
     * @param photo 
     * @param title 
     * @param link 
     * @param price 
     * @param priceOld 
     * @param button 
     */
    suspend fun edit(ownerId: Long, cardId: Long, photo: String? = null, title: String? = null, link: String? = null, price: String? = null, priceOld: String? = null, button: String? = null): PrettyCardsEditResponse {
        val response = method("edit", mapOf("owner_id" to ownerId, "card_id" to cardId, "photo" to photo, "title" to title, "link" to link, "price" to price, "price_old" to priceOld, "button" to button))
        return json.decodeFromString<PrettyCardsEditResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param offset 
     * @param count 
     */
    suspend fun get(ownerId: Long, offset: Int? = 0, count: Int? = 10): PrettyCardsGetResponse {
        val response = method("get", mapOf("owner_id" to ownerId, "offset" to offset, "count" to count))
        return json.decodeFromString<PrettyCardsGetResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param cardIds 
     */
    suspend fun getById(ownerId: Long, cardIds: List<Int>): PrettyCardsGetByIdResponse {
        val response = method("getById", mapOf("owner_id" to ownerId, "card_ids" to cardIds))
        return json.decodeFromString<PrettyCardsGetByIdResponse>(response)
    }

    /**
     *
     */
    suspend fun getUploadURL(): PrettyCardsGetUploadURLResponse {
        val response = method("getUploadURL", mapOf())
        return json.decodeFromString<PrettyCardsGetUploadURLResponse>(response)
    }

}
