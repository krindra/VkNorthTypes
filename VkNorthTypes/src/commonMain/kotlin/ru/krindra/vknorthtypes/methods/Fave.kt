package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.fave.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseUserGroupFields
import ru.krindra.vknorthtypes.types.base.BaseBoolResponse
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Fave(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param url 
     */
    suspend fun addArticle(url: String): BaseOkResponse {
        val response = method("addArticle", mapOf("url" to url))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Adds a link to user faves.
     * 
     * @param link Link URL.
     */
    suspend fun addLink(link: String): BaseOkResponse {
        val response = method("addLink", mapOf("link" to link))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param userId 
     * @param groupId 
     */
    suspend fun addPage(userId: Long? = null, groupId: Long? = null): BaseOkResponse {
        val response = method("addPage", mapOf("user_id" to userId, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param id 
     * @param accessKey 
     */
    suspend fun addPost(ownerId: Long, id: Long, accessKey: String? = null): BaseOkResponse {
        val response = method("addPost", mapOf("owner_id" to ownerId, "id" to id, "access_key" to accessKey))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param id 
     * @param accessKey 
     */
    suspend fun addProduct(ownerId: Long, id: Long, accessKey: String? = null): BaseOkResponse {
        val response = method("addProduct", mapOf("owner_id" to ownerId, "id" to id, "access_key" to accessKey))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param name 
     * @param position 
     */
    suspend fun addTag(name: String? = null, position: String? = "back"): FaveAddTagResponse {
        val response = method("addTag", mapOf("name" to name, "position" to position))
        return json.decodeFromString<FaveAddTagResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param id 
     * @param accessKey 
     */
    suspend fun addVideo(ownerId: Long, id: Long, accessKey: String? = null): BaseOkResponse {
        val response = method("addVideo", mapOf("owner_id" to ownerId, "id" to id, "access_key" to accessKey))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param id 
     * @param name 
     */
    suspend fun editTag(id: Long, name: String): BaseOkResponse {
        val response = method("editTag", mapOf("id" to id, "name" to name))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param extended '1' - to return additional 'wall', 'profiles', and 'groups' fields. By default: '0'.
     * @param itemType 
     * @param tagId Tag ID.
     * @param offset Offset needed to return a specific subset of users.
     * @param count Number of users to return.
     * @param fields 
     * @param isFromSnackbar 
     */
    suspend fun get(extended: Boolean? = false, itemType: String? = null, tagId: Long? = null, offset: Int? = null, count: Int? = 50, fields: String? = null, isFromSnackbar: Boolean? = false): GetResponse {
        val response = method("get", mapOf("extended" to extended, "item_type" to itemType, "tag_id" to tagId, "offset" to offset, "count" to count, "fields" to fields, "is_from_snackbar" to isFromSnackbar))
        return GetResponse(response, json)
    }
    class GetResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(FaveGetResponse.serializer(), FaveGetExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun FaveGetResponse(): FaveGetResponse?{
            return if (response is FaveGetResponse) response else null
        }
        fun FaveGetExtendedResponse(): FaveGetExtendedResponse?{
            return if (response is FaveGetExtendedResponse) response else null
        }
    }

    /**
     *
     * @param offset 
     * @param count 
     * @param type 
     * @param fields 
     * @param tagId 
     */
    suspend fun getPages(offset: Int? = null, count: Int? = 50, type: String? = null, fields: List<BaseUserGroupFields>? = null, tagId: Long? = null): FaveGetPagesResponse {
        val response = method("getPages", mapOf("offset" to offset, "count" to count, "type" to type, "fields" to fields, "tag_id" to tagId))
        return json.decodeFromString<FaveGetPagesResponse>(response)
    }

    /**
     *
     */
    suspend fun getTags(): FaveGetTagsResponse {
        val response = method("getTags", mapOf())
        return json.decodeFromString<FaveGetTagsResponse>(response)
    }

    /**
     *
     */
    suspend fun markSeen(): BaseBoolResponse {
        val response = method("markSeen", mapOf())
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param articleId 
     */
    suspend fun removeArticle(ownerId: Long, articleId: Long): BaseBoolResponse {
        val response = method("removeArticle", mapOf("owner_id" to ownerId, "article_id" to articleId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Removes link from the user's faves.
     * 
     * @param linkId Link ID (can be obtained by [vk.com/dev/faves.getLinks|faves.getLinks] method).
     * @param link Link URL.
     */
    suspend fun removeLink(linkId: String? = null, link: String? = null): BaseOkResponse {
        val response = method("removeLink", mapOf("link_id" to linkId, "link" to link))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param userId 
     * @param groupId 
     */
    suspend fun removePage(userId: Long? = null, groupId: Long? = null): BaseOkResponse {
        val response = method("removePage", mapOf("user_id" to userId, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param id 
     */
    suspend fun removePost(ownerId: Long, id: Long): BaseOkResponse {
        val response = method("removePost", mapOf("owner_id" to ownerId, "id" to id))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param id 
     */
    suspend fun removeProduct(ownerId: Long, id: Long): BaseOkResponse {
        val response = method("removeProduct", mapOf("owner_id" to ownerId, "id" to id))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param id 
     */
    suspend fun removeTag(id: Long): BaseOkResponse {
        val response = method("removeTag", mapOf("id" to id))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ownerId 
     * @param id 
     */
    suspend fun removeVideo(ownerId: Long, id: Long): BaseOkResponse {
        val response = method("removeVideo", mapOf("owner_id" to ownerId, "id" to id))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ids 
     */
    suspend fun reorderTags(ids: List<Int>): BaseOkResponse {
        val response = method("reorderTags", mapOf("ids" to ids))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param userId 
     * @param groupId 
     * @param tagIds 
     */
    suspend fun setPageTags(userId: Long? = null, groupId: Long? = null, tagIds: List<Int>? = null): BaseOkResponse {
        val response = method("setPageTags", mapOf("user_id" to userId, "group_id" to groupId, "tag_ids" to tagIds))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param itemType 
     * @param itemOwnerId 
     * @param itemId 
     * @param tagIds 
     * @param linkId 
     * @param linkUrl 
     */
    suspend fun setTags(itemType: String? = null, itemOwnerId: Long? = null, itemId: Long? = null, tagIds: List<Int>? = null, linkId: String? = null, linkUrl: String? = null): BaseOkResponse {
        val response = method("setTags", mapOf("item_type" to itemType, "item_owner_id" to itemOwnerId, "item_id" to itemId, "tag_ids" to tagIds, "link_id" to linkId, "link_url" to linkUrl))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param userId 
     * @param groupId 
     */
    suspend fun trackPageInteraction(userId: Long? = null, groupId: Long? = null): BaseOkResponse {
        val response = method("trackPageInteraction", mapOf("user_id" to userId, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
