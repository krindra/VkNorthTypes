package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.market.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.users.UsersFields
import ru.krindra.vknorthtypes.types.base.BaseBoolResponse
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Market(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Ads a new item to the market.
     * 
     * @param ownerId ID of an item owner community.
     * @param name Item name.
     * @param description Item description.
     * @param categoryId Item category ID.
     * @param price Item price.
     * @param oldPrice 
     * @param deleted Item status ('1' - deleted, '0' - not deleted).
     * @param mainPhotoId Cover photo ID.
     * @param photoIds IDs of additional photos.
     * @param videoIds IDs of additional videos.
     * @param url Url for button in market item.
     * @param dimensionWidth 
     * @param dimensionHeight 
     * @param dimensionLength 
     * @param weight 
     * @param sku 
     */
    suspend fun add(ownerId: Long, name: String, description: String, categoryId: Long, price: Double? = null, oldPrice: Double? = null, deleted: Boolean? = false, mainPhotoId: Long? = null, photoIds: List<Int>? = null, videoIds: List<Int>? = null, url: String? = null, dimensionWidth: Int? = null, dimensionHeight: Int? = null, dimensionLength: Int? = null, weight: Int? = null, sku: String? = null): MarketAddResponse {
        val response = method("add", mapOf("owner_id" to ownerId, "name" to name, "description" to description, "category_id" to categoryId, "price" to price, "old_price" to oldPrice, "deleted" to deleted, "main_photo_id" to mainPhotoId, "photo_ids" to photoIds, "video_ids" to videoIds, "url" to url, "dimension_width" to dimensionWidth, "dimension_height" to dimensionHeight, "dimension_length" to dimensionLength, "weight" to weight, "sku" to sku))
        return json.decodeFromString<MarketAddResponse>(response)
    }

    /**
     *
     * Creates new collection of items
     * 
     * @param ownerId ID of an item owner community.
     * @param title Collection title.
     * @param photoId Cover photo ID.
     * @param mainAlbum Set as main ('1' - set, '0' - no).
     * @param isHidden Set as hidden.
     */
    suspend fun addAlbum(ownerId: Long, title: String, photoId: Long? = null, mainAlbum: Boolean? = false, isHidden: Boolean? = false): MarketAddAlbumResponse {
        val response = method("addAlbum", mapOf("owner_id" to ownerId, "title" to title, "photo_id" to photoId, "main_album" to mainAlbum, "is_hidden" to isHidden))
        return json.decodeFromString<MarketAddAlbumResponse>(response)
    }

    /**
     *
     * Adds an item to one or multiple collections.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemIds 
     * @param albumIds Collections IDs to add item to.
     */
    suspend fun addToAlbum(ownerId: Long, itemIds: List<Int>, albumIds: List<Int>): BaseOkResponse {
        val response = method("addToAlbum", mapOf("owner_id" to ownerId, "item_ids" to itemIds, "album_ids" to albumIds))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Creates a new comment for an item.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Item ID.
     * @param message Comment text (required if 'attachments' parameter is not specified).
     * @param attachments Comma-separated list of objects attached to a comment. The field is submitted the following way: , "'<owner_id>_<media_id>,<owner_id>_<media_id>'", , '' - media attachment type: "'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document", , '<owner_id>' - media owner id, '<media_id>' - media attachment id, , For example: "photo100172_166443618,photo66748_265827614",.
     * @param fromGroup '1' - comment will be published on behalf of a community, '0' - on behalf of a user (by default).
     * @param replyToComment ID of a comment to reply with current comment to.
     * @param stickerId Sticker ID.
     * @param guid Random value to avoid resending one comment.
     */
    suspend fun createComment(ownerId: Long, itemId: Long, message: String? = null, attachments: List<String>? = null, fromGroup: Boolean? = false, replyToComment: Int? = null, stickerId: Long? = null, guid: String? = null): MarketCreateCommentResponse {
        val response = method("createComment", mapOf("owner_id" to ownerId, "item_id" to itemId, "message" to message, "attachments" to attachments, "from_group" to fromGroup, "reply_to_comment" to replyToComment, "sticker_id" to stickerId, "guid" to guid))
        return json.decodeFromString<MarketCreateCommentResponse>(response)
    }

    /**
     *
     * Deletes an item.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Item ID.
     */
    suspend fun delete(ownerId: Long, itemId: Long): BaseOkResponse {
        val response = method("delete", mapOf("owner_id" to ownerId, "item_id" to itemId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Deletes a collection of items.
     * 
     * @param ownerId ID of an collection owner community.
     * @param albumId Collection ID.
     */
    suspend fun deleteAlbum(ownerId: Long, albumId: Long): BaseOkResponse {
        val response = method("deleteAlbum", mapOf("owner_id" to ownerId, "album_id" to albumId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Deletes an item's comment
     * 
     * @param ownerId identifier of an item owner community, "Note that community id in the 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK API] community ".
     * @param commentId comment id.
     */
    suspend fun deleteComment(ownerId: Long, commentId: Long): BaseBoolResponse {
        val response = method("deleteComment", mapOf("owner_id" to ownerId, "comment_id" to commentId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Edits an item.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Item ID.
     * @param name Item name.
     * @param description Item description.
     * @param categoryId Item category ID.
     * @param price Item price.
     * @param oldPrice 
     * @param deleted Item status ('1' - deleted, '0' - not deleted).
     * @param mainPhotoId Cover photo ID.
     * @param photoIds IDs of additional photos.
     * @param videoIds IDs of additional videos.
     * @param url Url for button in market item.
     * @param dimensionWidth 
     * @param dimensionHeight 
     * @param dimensionLength 
     * @param weight 
     * @param sku 
     */
    suspend fun edit(ownerId: Long, itemId: Long, name: String? = null, description: String? = null, categoryId: Long? = null, price: Double? = null, oldPrice: Double? = null, deleted: Boolean? = false, mainPhotoId: Long? = null, photoIds: List<Int>? = null, videoIds: List<Int>? = null, url: String? = null, dimensionWidth: Int? = null, dimensionHeight: Int? = null, dimensionLength: Int? = null, weight: Int? = null, sku: String? = null): BaseOkResponse {
        val response = method("edit", mapOf("owner_id" to ownerId, "item_id" to itemId, "name" to name, "description" to description, "category_id" to categoryId, "price" to price, "old_price" to oldPrice, "deleted" to deleted, "main_photo_id" to mainPhotoId, "photo_ids" to photoIds, "video_ids" to videoIds, "url" to url, "dimension_width" to dimensionWidth, "dimension_height" to dimensionHeight, "dimension_length" to dimensionLength, "weight" to weight, "sku" to sku))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits a collection of items
     * 
     * @param ownerId ID of an collection owner community.
     * @param albumId Collection ID.
     * @param title Collection title.
     * @param photoId Cover photo id.
     * @param mainAlbum Set as main ('1' - set, '0' - no).
     * @param isHidden Set as hidden.
     */
    suspend fun editAlbum(ownerId: Long, albumId: Long, title: String, photoId: Long? = null, mainAlbum: Boolean? = false, isHidden: Boolean? = false): BaseOkResponse {
        val response = method("editAlbum", mapOf("owner_id" to ownerId, "album_id" to albumId, "title" to title, "photo_id" to photoId, "main_album" to mainAlbum, "is_hidden" to isHidden))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Chages item comment's text
     * 
     * @param ownerId ID of an item owner community.
     * @param commentId Comment ID.
     * @param message New comment text (required if 'attachments' are not specified), , 2048 symbols maximum.
     * @param attachments Comma-separated list of objects attached to a comment. The field is submitted the following way: , "'<owner_id>_<media_id>,<owner_id>_<media_id>'", , '' - media attachment type: "'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document", , '<owner_id>' - media owner id, '<media_id>' - media attachment id, , For example: "photo100172_166443618,photo66748_265827614",.
     */
    suspend fun editComment(ownerId: Long, commentId: Long, message: String? = null, attachments: List<String>? = null): BaseOkResponse {
        val response = method("editComment", mapOf("owner_id" to ownerId, "comment_id" to commentId, "message" to message, "attachments" to attachments))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edit order
     * 
     * @param userId 
     * @param orderId 
     * @param merchantComment 
     * @param status 
     * @param trackNumber 
     * @param paymentStatus 
     * @param deliveryPrice 
     * @param width 
     * @param length 
     * @param height 
     * @param weight 
     * @param commentForUser 
     * @param receiptLink 
     */
    suspend fun editOrder(userId: Long, orderId: Long, merchantComment: String? = null, status: Int? = null, trackNumber: String? = null, paymentStatus: String? = null, deliveryPrice: Int? = null, width: Int? = null, length: Int? = null, height: Int? = null, weight: Int? = null, commentForUser: String? = null, receiptLink: String? = null): BaseOkResponse {
        val response = method("editOrder", mapOf("user_id" to userId, "order_id" to orderId, "merchant_comment" to merchantComment, "status" to status, "track_number" to trackNumber, "payment_status" to paymentStatus, "delivery_price" to deliveryPrice, "width" to width, "length" to length, "height" to height, "weight" to weight, "comment_for_user" to commentForUser, "receipt_link" to receiptLink))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns a filter list of market categories.
     * 
     * @param categoryId Category_id filter categories.
     * @param query Query filter categories.
     * @param count Number of results to return.
     */
    suspend fun filterCategories(categoryId: Long? = null, query: String? = null, count: Int? = 20): MarketGetCategoriesNewResponse {
        val response = method("filterCategories", mapOf("category_id" to categoryId, "query" to query, "count" to count))
        return json.decodeFromString<MarketGetCategoriesNewResponse>(response)
    }

    /**
     *
     * Returns items list for a community.
     * 
     * @param ownerId ID of an item owner community, "Note that community id in the 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK API] community ".
     * @param albumId 
     * @param count Number of items to return.
     * @param offset Offset needed to return a specific subset of results.
     * @param extended '1' - method will return additional fields: 'likes, can_comment, car_repost, photos'. These parameters are not returned by default.
     * @param dateFrom Items update date from (format: yyyy-mm-dd).
     * @param dateTo Items update date to (format: yyyy-mm-dd).
     * @param needVariants Add variants to response if exist.
     * @param withDisabled Add disabled items to response.
     */
    suspend fun get(ownerId: Long, albumId: Long? = 0, count: Int? = 100, offset: Int? = null, extended: Boolean? = false, dateFrom: String? = null, dateTo: String? = null, needVariants: Boolean? = false, withDisabled: Boolean? = false): GetResponse {
        val response = method("get", mapOf("owner_id" to ownerId, "album_id" to albumId, "count" to count, "offset" to offset, "extended" to extended, "date_from" to dateFrom, "date_to" to dateTo, "need_variants" to needVariants, "with_disabled" to withDisabled))
        return GetResponse(response, json)
    }
    class GetResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MarketGetExtendedResponse.serializer(), MarketGetResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MarketGetExtendedResponse(): MarketGetExtendedResponse?{
            return if (response is MarketGetExtendedResponse) response else null
        }
        fun MarketGetResponse(): MarketGetResponse?{
            return if (response is MarketGetResponse) response else null
        }
    }

    /**
     *
     * Returns items album's data
     * 
     * @param ownerId identifier of an album owner community, "Note that community id in the 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK API] community ".
     * @param albumIds collections identifiers to obtain data from.
     */
    suspend fun getAlbumById(ownerId: Long, albumIds: List<Int>): MarketGetAlbumByIdResponse {
        val response = method("getAlbumById", mapOf("owner_id" to ownerId, "album_ids" to albumIds))
        return json.decodeFromString<MarketGetAlbumByIdResponse>(response)
    }

    /**
     *
     * Returns community's market collections list.
     * 
     * @param ownerId ID of an items owner community.
     * @param offset Offset needed to return a specific subset of results.
     * @param count Number of items to return.
     */
    suspend fun getAlbums(ownerId: Long, offset: Int? = null, count: Int? = 50): MarketGetAlbumsResponse {
        val response = method("getAlbums", mapOf("owner_id" to ownerId, "offset" to offset, "count" to count))
        return json.decodeFromString<MarketGetAlbumsResponse>(response)
    }

    /**
     *
     * Returns information about market items by their ids.
     * 
     * @param itemIds Comma-separated ids list: {user id}_{item id}. If an item belongs to a community -{community id} is used. " 'Videos' value example: , '-4363_136089719,13245770_137352259'".
     * @param extended '1' - to return additional fields: 'likes, can_comment, car_repost, photos'. By default: '0'.
     */
    suspend fun getById(itemIds: List<String>, extended: Boolean? = false): GetbyidResponse {
        val response = method("getById", mapOf("item_ids" to itemIds, "extended" to extended))
        return GetbyidResponse(response, json)
    }
    class GetbyidResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MarketGetByIdExtendedResponse.serializer(), MarketGetByIdResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MarketGetByIdExtendedResponse(): MarketGetByIdExtendedResponse?{
            return if (response is MarketGetByIdExtendedResponse) response else null
        }
        fun MarketGetByIdResponse(): MarketGetByIdResponse?{
            return if (response is MarketGetByIdResponse) response else null
        }
    }

    /**
     *
     * Returns a list of market categories.
     * 
     * @param groupId Group Id.
     * @param albumId 
     */
    suspend fun getCategories(groupId: Long? = null, albumId: Long? = null): MarketGetCategoriesNewResponse {
        val response = method("getCategories", mapOf("group_id" to groupId, "album_id" to albumId))
        return json.decodeFromString<MarketGetCategoriesNewResponse>(response)
    }

    /**
     *
     * Returns comments list for an item.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Item ID.
     * @param needLikes '1' - to return likes info.
     * @param startCommentId ID of a comment to start a list from (details below).
     * @param offset 
     * @param count Number of results to return.
     * @param sort Sort order ('asc' - from old to new, 'desc' - from new to old).
     * @param extended '1' - comments will be returned as numbered objects, in addition lists of 'profiles' and 'groups' objects will be returned.
     * @param fields List of additional profile fields to return. See the [vk.com/dev/fields|details].
     */
    suspend fun getComments(ownerId: Long, itemId: Long, needLikes: Boolean? = false, startCommentId: Long? = null, offset: Int? = 0, count: Int? = 20, sort: String? = "asc", extended: Boolean? = false, fields: List<UsersFields>? = null): MarketGetCommentsResponse {
        val response = method("getComments", mapOf("owner_id" to ownerId, "item_id" to itemId, "need_likes" to needLikes, "start_comment_id" to startCommentId, "offset" to offset, "count" to count, "sort" to sort, "extended" to extended, "fields" to fields))
        return json.decodeFromString<MarketGetCommentsResponse>(response)
    }

    /**
     *
     * Get market orders
     * 
     * @param groupId ID or groups domain.
     * @param offset 
     * @param count 
     */
    suspend fun getGroupOrders(groupId: List<Any>? = null, offset: Int? = 0, count: Int? = 10): MarketGetGroupOrdersResponse {
        val response = method("getGroupOrders", mapOf("group_id" to groupId, "offset" to offset, "count" to count))
        return json.decodeFromString<MarketGetGroupOrdersResponse>(response)
    }

    /**
     *
     * Get order
     * 
     * @param userId 
     * @param orderId 
     * @param extended 
     */
    suspend fun getOrderById(orderId: Long, userId: Long? = null, extended: Boolean? = false): MarketGetOrderByIdResponse {
        val response = method("getOrderById", mapOf("user_id" to userId, "order_id" to orderId, "extended" to extended))
        return json.decodeFromString<MarketGetOrderByIdResponse>(response)
    }

    /**
     *
     * Get market items in the order
     * 
     * @param userId 
     * @param orderId 
     * @param offset 
     * @param count 
     */
    suspend fun getOrderItems(orderId: Long, userId: Long? = null, offset: Int? = null, count: Int? = 50): MarketGetOrderItemsResponse {
        val response = method("getOrderItems", mapOf("user_id" to userId, "order_id" to orderId, "offset" to offset, "count" to count))
        return json.decodeFromString<MarketGetOrderItemsResponse>(response)
    }

    /**
     *
     * @param offset 
     * @param count 
     * @param extended 
     * @param dateFrom Orders status updated date from (format: yyyy-mm-dd).
     * @param dateTo Orders status updated date to (format: yyyy-mm-dd).
     */
    suspend fun getOrders(offset: Int? = 0, count: Int? = 10, extended: Boolean? = false, dateFrom: String? = null, dateTo: String? = null): GetordersResponse {
        val response = method("getOrders", mapOf("offset" to offset, "count" to count, "extended" to extended, "date_from" to dateFrom, "date_to" to dateTo))
        return GetordersResponse(response, json)
    }
    class GetordersResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MarketGetOrdersExtendedResponse.serializer(), MarketGetOrdersResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MarketGetOrdersExtendedResponse(): MarketGetOrdersExtendedResponse?{
            return if (response is MarketGetOrdersExtendedResponse) response else null
        }
        fun MarketGetOrdersResponse(): MarketGetOrdersResponse?{
            return if (response is MarketGetOrdersResponse) response else null
        }
    }

    /**
     *
     * Removes an item from one or multiple collections.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Item ID.
     * @param albumIds Collections IDs to remove item from.
     */
    suspend fun removeFromAlbum(ownerId: Long, itemId: Long, albumIds: List<Int>): BaseOkResponse {
        val response = method("removeFromAlbum", mapOf("owner_id" to ownerId, "item_id" to itemId, "album_ids" to albumIds))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Reorders the collections list.
     * 
     * @param ownerId ID of an item owner community.
     * @param albumId Collection ID.
     * @param before ID of a collection to place current collection before it.
     * @param after ID of a collection to place current collection after it.
     */
    suspend fun reorderAlbums(ownerId: Long, albumId: Long, before: Int? = null, after: Int? = null): BaseOkResponse {
        val response = method("reorderAlbums", mapOf("owner_id" to ownerId, "album_id" to albumId, "before" to before, "after" to after))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Changes item place in a collection.
     * 
     * @param ownerId ID of an item owner community.
     * @param albumId ID of a collection to reorder items in. Set 0 to reorder full items list.
     * @param itemId Item ID.
     * @param before ID of an item to place current item before it.
     * @param after ID of an item to place current item after it.
     */
    suspend fun reorderItems(ownerId: Long, itemId: Long, albumId: Long? = null, before: Int? = null, after: Int? = null): BaseOkResponse {
        val response = method("reorderItems", mapOf("owner_id" to ownerId, "album_id" to albumId, "item_id" to itemId, "before" to before, "after" to after))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Sends a complaint to the item.
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Item ID.
     * @param reason Complaint reason. Possible values: *'0' - spam,, *'1' - child porn,, *'2' - extremism,, *'3' - violence,, *'4' - drugs propaganda,, *'5' - adult materials,, *'6' - insult.
     */
    suspend fun report(ownerId: Long, itemId: Long, reason: Int? = 0): BaseOkResponse {
        val response = method("report", mapOf("owner_id" to ownerId, "item_id" to itemId, "reason" to reason))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Sends a complaint to the item's comment.
     * 
     * @param ownerId ID of an item owner community.
     * @param commentId Comment ID.
     * @param reason Complaint reason. Possible values: *'0' - spam,, *'1' - child porn,, *'2' - extremism,, *'3' - violence,, *'4' - drugs propaganda,, *'5' - adult materials,, *'6' - insult.
     */
    suspend fun reportComment(ownerId: Long, commentId: Long, reason: Int): BaseOkResponse {
        val response = method("reportComment", mapOf("owner_id" to ownerId, "comment_id" to commentId, "reason" to reason))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Restores recently deleted item
     * 
     * @param ownerId ID of an item owner community.
     * @param itemId Deleted item ID.
     */
    suspend fun restore(ownerId: Long, itemId: Long): BaseOkResponse {
        val response = method("restore", mapOf("owner_id" to ownerId, "item_id" to itemId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Restores a recently deleted comment
     * 
     * @param ownerId identifier of an item owner community, "Note that community id in the 'owner_id' parameter should be negative number. For example 'owner_id'=-1 matches the [vk.com/apiclub|VK API] community ".
     * @param commentId deleted comment id.
     */
    suspend fun restoreComment(ownerId: Long, commentId: Long): BaseBoolResponse {
        val response = method("restoreComment", mapOf("owner_id" to ownerId, "comment_id" to commentId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Searches market items in a community's catalog
     * 
     * @param ownerId ID of an items owner community.
     * @param albumId 
     * @param q Search query, for example "pink slippers".
     * @param priceFrom Minimum item price value.
     * @param priceTo Maximum item price value.
     * @param sort 
     * @param rev '0' - do not use reverse order, '1' - use reverse order.
     * @param offset Offset needed to return a specific subset of results.
     * @param count Number of items to return.
     * @param extended '1' - to return additional fields: 'likes, can_comment, car_repost, photos'. By default: '0'.
     * @param status 
     * @param needVariants Add variants to response if exist.
     */
    suspend fun search(ownerId: Long, albumId: Long? = null, q: String? = null, priceFrom: Int? = null, priceTo: Int? = null, sort: Int? = 0, rev: Int? = 1, offset: Int? = null, count: Int? = 20, extended: Boolean? = true, status: List<Int>? = null, needVariants: Boolean? = false): SearchResponse {
        val response = method("search", mapOf("owner_id" to ownerId, "album_id" to albumId, "q" to q, "price_from" to priceFrom, "price_to" to priceTo, "sort" to sort, "rev" to rev, "offset" to offset, "count" to count, "extended" to extended, "status" to status, "need_variants" to needVariants))
        return SearchResponse(response, json)
    }
    class SearchResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MarketSearchResponse.serializer(), MarketSearchExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MarketSearchResponse(): MarketSearchResponse?{
            return if (response is MarketSearchResponse) response else null
        }
        fun MarketSearchExtendedResponse(): MarketSearchExtendedResponse?{
            return if (response is MarketSearchExtendedResponse) response else null
        }
    }

    /**
     *
     * @param q 
     * @param offset 
     * @param count 
     * @param categoryId 
     * @param priceFrom 
     * @param priceTo 
     * @param sortBy 
     * @param sortDirection 
     * @param country 
     * @param city 
     */
    suspend fun searchItems(q: String, offset: Int? = 0, count: Int? = 30, categoryId: Long? = null, priceFrom: Int? = null, priceTo: Int? = null, sortBy: Int? = 3, sortDirection: Int? = 1, country: Int? = null, city: Int? = null): MarketSearchResponse {
        val response = method("searchItems", mapOf("q" to q, "offset" to offset, "count" to count, "category_id" to categoryId, "price_from" to priceFrom, "price_to" to priceTo, "sort_by" to sortBy, "sort_direction" to sortDirection, "country" to country, "city" to city))
        return json.decodeFromString<MarketSearchResponse>(response)
    }

    /**
     *
     * @param q 
     * @param offset 
     * @param count 
     * @param categoryId 
     * @param priceFrom 
     * @param priceTo 
     * @param sortBy 
     * @param sortDirection 
     * @param country 
     * @param city 
     * @param onlyMyGroups 
     */
    suspend fun searchItemsBasic(q: String, offset: Int? = 0, count: Int? = 30, categoryId: Long? = null, priceFrom: Int? = null, priceTo: Int? = null, sortBy: Int? = 3, sortDirection: Int? = 0, country: Int? = null, city: Int? = null, onlyMyGroups: Boolean? = false): MarketSearchBasicResponse {
        val response = method("searchItemsBasic", mapOf("q" to q, "offset" to offset, "count" to count, "category_id" to categoryId, "price_from" to priceFrom, "price_to" to priceTo, "sort_by" to sortBy, "sort_direction" to sortDirection, "country" to country, "city" to city, "only_my_groups" to onlyMyGroups))
        return json.decodeFromString<MarketSearchBasicResponse>(response)
    }

}
