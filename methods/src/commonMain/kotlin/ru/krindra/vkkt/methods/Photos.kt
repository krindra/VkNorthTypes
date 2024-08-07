package ru.krindra.vkkt.methods

import ru.krindra.vkkt.responses.photos.*
import ru.krindra.vkkt.objects.photos.*
import ru.krindra.vkkt.utils.JsonSingleton
import kotlinx.serialization.json.Json
import ru.krindra.vkkt.objects.users.UsersFields
import ru.krindra.vkkt.responses.base.BaseOkResponse
import ru.krindra.vkkt.responses.base.BaseBoolResponse
import ru.krindra.vkkt.responses.base.BaseGetUploadServerResponse

class Photos(
    private val method: suspend (String, Map<String, Any?>?) -> String,
    private val json: Json = JsonSingleton.json
    ) {
    /**
     *
     * Confirms a tag on a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param tagId Tag ID.
     */
    suspend fun confirmTag(photoId: String, tagId: Int, ownerId: Int? = null): BaseOkResponse {
        val response = method("photos.confirmTag", mapOf("owner_id" to ownerId, "photo_id" to photoId, "tag_id" to tagId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Allows to copy a photo to the "Saved photos" album
     * 
     * @param ownerId photo's owner ID.
     * @param photoId photo ID.
     * @param accessKey for private photos.
     */
    suspend fun copy(ownerId: Int, photoId: Int, accessKey: String? = null): PhotosCopyResponse {
        val response = method("photos.copy", mapOf("owner_id" to ownerId, "photo_id" to photoId, "access_key" to accessKey))
        return decodeResponse(response, json)
    }

    /**
     *
     * Creates an empty photo album.
     * 
     * @param title Album title.
     * @param groupId ID of the community in which the album will be created.
     * @param description Album description.
     * @param privacyView 
     * @param privacyComment 
     * @param uploadByAdminsOnly 
     * @param commentsDisabled 
     */
    suspend fun createAlbum(title: String, groupId: Int? = null, description: String? = null, privacyView: List<String>? = listOf("all"), privacyComment: List<String>? = listOf("all"), uploadByAdminsOnly: Boolean? = false, commentsDisabled: Boolean? = false): PhotosCreateAlbumResponse {
        val response = method("photos.createAlbum", mapOf("title" to title, "group_id" to groupId, "description" to description, "privacy_view" to privacyView, "privacy_comment" to privacyComment, "upload_by_admins_only" to uploadByAdminsOnly, "comments_disabled" to commentsDisabled))
        return decodeResponse(response, json)
    }

    /**
     *
     * Adds a new comment on the photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param message Comment text.
     * @param attachments (Required if 'message' is not set.) List of objects attached to the post, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment: 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - Media attachment owner ID. '<media_id>' - Media attachment ID. Example: "photo100172_166443618,photo66748_265827614".
     * @param fromGroup '1' - to post a comment from the community.
     * @param replyToComment 
     * @param stickerId 
     * @param accessKey 
     * @param guid 
     */
    suspend fun createComment(photoId: Int, ownerId: Int? = null, message: String? = null, attachments: List<String>? = null, fromGroup: Boolean? = false, replyToComment: Int? = null, stickerId: Int? = null, accessKey: String? = null, guid: String? = null): PhotosCreateCommentResponse {
        val response = method("photos.createComment", mapOf("owner_id" to ownerId, "photo_id" to photoId, "message" to message, "attachments" to attachments, "from_group" to fromGroup, "reply_to_comment" to replyToComment, "sticker_id" to stickerId, "access_key" to accessKey, "guid" to guid))
        return decodeResponse(response, json)
    }

    /**
     *
     * Deletes a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param photos 
     */
    suspend fun delete(ownerId: Int? = null, photoId: Int? = null, photos: List<String>? = null): BaseOkResponse {
        val response = method("photos.delete", mapOf("owner_id" to ownerId, "photo_id" to photoId, "photos" to photos))
        return decodeResponse(response, json)
    }

    /**
     *
     * Deletes a photo album belonging to the current user.
     * 
     * @param albumId Album ID.
     * @param groupId ID of the community that owns the album.
     */
    suspend fun deleteAlbum(albumId: Int, groupId: Int? = null): BaseOkResponse {
        val response = method("photos.deleteAlbum", mapOf("album_id" to albumId, "group_id" to groupId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Deletes a comment on the photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param commentId Comment ID.
     */
    suspend fun deleteComment(commentId: Int, ownerId: Int? = null): BaseBoolResponse {
        val response = method("photos.deleteComment", mapOf("owner_id" to ownerId, "comment_id" to commentId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Edits the caption of a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param caption New caption for the photo. If this parameter is not set, it is considered to be equal to an empty string.
     * @param latitude 
     * @param longitude 
     * @param placeStr 
     * @param foursquareId 
     * @param deletePlace 
     */
    suspend fun edit(photoId: Int, ownerId: Int? = null, caption: String? = null, latitude: Double? = null, longitude: Double? = null, placeStr: String? = null, foursquareId: String? = null, deletePlace: Boolean? = false): BaseOkResponse {
        val response = method("photos.edit", mapOf("owner_id" to ownerId, "photo_id" to photoId, "caption" to caption, "latitude" to latitude, "longitude" to longitude, "place_str" to placeStr, "foursquare_id" to foursquareId, "delete_place" to deletePlace))
        return decodeResponse(response, json)
    }

    /**
     *
     * Edits information about a photo album.
     * 
     * @param albumId ID of the photo album to be edited.
     * @param title New album title.
     * @param description New album description.
     * @param ownerId ID of the user or community that owns the album.
     * @param privacyView 
     * @param privacyComment 
     * @param uploadByAdminsOnly 
     * @param commentsDisabled 
     */
    suspend fun editAlbum(albumId: Int, title: String? = null, description: String? = null, ownerId: Int? = null, privacyView: List<String>? = null, privacyComment: List<String>? = null, uploadByAdminsOnly: Boolean? = false, commentsDisabled: Boolean? = false): BaseOkResponse {
        val response = method("photos.editAlbum", mapOf("album_id" to albumId, "title" to title, "description" to description, "owner_id" to ownerId, "privacy_view" to privacyView, "privacy_comment" to privacyComment, "upload_by_admins_only" to uploadByAdminsOnly, "comments_disabled" to commentsDisabled))
        return decodeResponse(response, json)
    }

    /**
     *
     * Edits a comment on a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param commentId Comment ID.
     * @param message New text of the comment.
     * @param attachments (Required if 'message' is not set.) List of objects attached to the post, in the following format: "<owner_id>_<media_id>,<owner_id>_<media_id>", '' - Type of media attachment: 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, '<owner_id>' - Media attachment owner ID. '<media_id>' - Media attachment ID. Example: "photo100172_166443618,photo66748_265827614".
     */
    suspend fun editComment(commentId: Int, ownerId: Int? = null, message: String? = null, attachments: List<String>? = null): BaseOkResponse {
        val response = method("photos.editComment", mapOf("owner_id" to ownerId, "comment_id" to commentId, "message" to message, "attachments" to attachments))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of a user's or community's photos.
     * 
     * @param ownerId ID of the user or community that owns the photos. Use a negative value to designate a community ID.
     * @param albumId Photo album ID. To return information about photos from service albums, use the following string values: 'profile, wall, saved'.
     * @param photoIds Photo IDs.
     * @param rev Sort order: '1' - reverse chronological, '0' - chronological.
     * @param extended '1' - to return additional 'likes', 'comments', and 'tags' fields, '0' - (default).
     * @param feedType Type of feed obtained in 'feed' field of the method.
     * @param feed unixtime, that can be obtained with [vk.com/dev/newsfeed.get|newsfeed.get] method in date field to get all photos uploaded by the user on a specific day, or photos the user has been tagged on. Also, 'uid' parameter of the user the event happened with shall be specified.
     * @param photoSizes '1' - to return photo sizes in a [vk.com/dev/photo_sizes|special format].
     * @param offset 
     * @param count 
     */
    suspend fun get(ownerId: Int? = null, albumId: String? = null, photoIds: List<String>? = null, rev: Boolean? = false, extended: Boolean? = false, feedType: String? = null, feed: Int? = null, photoSizes: Boolean? = false, offset: Int? = null, count: Int? = 50): PhotosGetResponse {
        val response = method("photos.get", mapOf("owner_id" to ownerId, "album_id" to albumId, "photo_ids" to photoIds, "rev" to rev, "extended" to extended, "feed_type" to feedType, "feed" to feed, "photo_sizes" to photoSizes, "offset" to offset, "count" to count))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of a user's or community's photo albums.
     * 
     * @param ownerId ID of the user or community that owns the albums.
     * @param albumIds Album IDs.
     * @param offset Offset needed to return a specific subset of albums.
     * @param count Number of albums to return.
     * @param needSystem '1' - to return system albums with negative IDs.
     * @param needCovers '1' - to return an additional 'thumb_src' field, '0' - (default).
     * @param photoSizes '1' - to return photo sizes in a.
     */
    suspend fun getAlbums(ownerId: Int? = null, albumIds: List<Int>? = null, offset: Int? = null, count: Int? = null, needSystem: Boolean? = false, needCovers: Boolean? = false, photoSizes: Boolean? = false): PhotosGetAlbumsResponse {
        val response = method("photos.getAlbums", mapOf("owner_id" to ownerId, "album_ids" to albumIds, "offset" to offset, "count" to count, "need_system" to needSystem, "need_covers" to needCovers, "photo_sizes" to photoSizes))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns the number of photo albums belonging to a user or community.
     * 
     * @param userId User ID.
     * @param groupId Community ID.
     * @param needSystem 
     */
    suspend fun getAlbumsCount(userId: Int? = null, groupId: Int? = null, needSystem: Boolean? = false): PhotosGetAlbumsCountResponse {
        val response = method("photos.getAlbumsCount", mapOf("user_id" to userId, "group_id" to groupId, "need_system" to needSystem))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of photos belonging to a user or community, in reverse chronological order.
     * 
     * @param ownerId ID of a user or community that owns the photos. Use a negative value to designate a community ID.
     * @param extended '1' - to return detailed information about photos.
     * @param offset Offset needed to return a specific subset of photos. By default, '0'.
     * @param count Number of photos to return.
     * @param photoSizes '1' - to return image sizes in [vk.com/dev/photo_sizes|special format].
     * @param noServiceAlbums '1' - to return photos only from standard albums, '0' - to return all photos including those in service albums, e.g., 'My wall photos' (default).
     * @param needHidden '1' - to show information about photos being hidden from the block above the wall.
     * @param skipHidden '1' - not to return photos being hidden from the block above the wall. Works only with owner_id>0, no_service_albums is ignored.
     */
    suspend fun getAll(ownerId: Int? = null, extended: Boolean? = false, offset: Int? = null, count: Int? = 20, photoSizes: Boolean? = false, noServiceAlbums: Boolean? = false, needHidden: Boolean? = false, skipHidden: Boolean? = false): PhotosGetAllResponse {
        val response = method("photos.getAll", mapOf("owner_id" to ownerId, "extended" to extended, "offset" to offset, "count" to count, "photo_sizes" to photoSizes, "no_service_albums" to noServiceAlbums, "need_hidden" to needHidden, "skip_hidden" to skipHidden))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of comments on a specific photo album or all albums of the user sorted in reverse chronological order.
     * 
     * @param ownerId ID of the user or community that owns the album(s).
     * @param albumId Album ID. If the parameter is not set, comments on all of the user's albums will be returned.
     * @param needLikes '1' - to return an additional 'likes' field, '0' - (default).
     * @param offset Offset needed to return a specific subset of comments. By default, '0'.
     * @param count Number of comments to return. By default, '20'. Maximum value, '100'.
     */
    suspend fun getAllComments(ownerId: Int? = null, albumId: Int? = null, needLikes: Boolean? = false, offset: Int? = null, count: Int? = null): PhotosGetAllCommentsResponse {
        val response = method("photos.getAllComments", mapOf("owner_id" to ownerId, "album_id" to albumId, "need_likes" to needLikes, "offset" to offset, "count" to count))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns information about photos by their IDs.
     * 
     * @param photos IDs separated with a comma, that are IDs of users who posted photos and IDs of photos themselves with an underscore character between such IDs. To get information about a photo in the group album, you shall specify group ID instead of user ID. Example: "1_129207899,6492_135055734, , -20629724_271945303".
     * @param extended '1' - to return additional fields, '0' - (default).
     * @param photoSizes '1' - to return photo sizes in a.
     */
    suspend fun getById(photos: List<String>, extended: Boolean? = false, photoSizes: Boolean? = false): PhotosGetByIdResponse {
        val response = method("photos.getById", mapOf("photos" to photos, "extended" to extended, "photo_sizes" to photoSizes))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns an upload link for chat cover pictures.
     * 
     * @param chatId ID of the chat for which you want to upload a cover photo.
     * @param cropX 
     * @param cropY 
     * @param cropWidth Width (in pixels) of the photo after cropping.
     */
    suspend fun getChatUploadServer(chatId: Int, cropX: Int? = null, cropY: Int? = null, cropWidth: Int? = null): BaseGetUploadServerResponse {
        val response = method("photos.getChatUploadServer", mapOf("chat_id" to chatId, "crop_x" to cropX, "crop_y" to cropY, "crop_width" to cropWidth))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of comments on a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param needLikes '1' - to return an additional 'likes' field, '0' - (default).
     * @param startCommentId 
     * @param offset Offset needed to return a specific subset of comments. By default, '0'.
     * @param count Number of comments to return.
     * @param sort Sort order: 'asc' - old first, 'desc' - new first.
     * @param accessKey 
     * @param extended 
     * @param fields 
     */
    suspend fun getComments(photoId: Int, ownerId: Int? = null, needLikes: Boolean? = false, startCommentId: Int? = null, offset: Int? = null, count: Int? = 20, sort: String? = null, accessKey: String? = null, extended: Boolean? = false, fields: List<UsersFields>? = null): GetCommentsResponse {
        val response = method("photos.getComments", mapOf("owner_id" to ownerId, "photo_id" to photoId, "need_likes" to needLikes, "start_comment_id" to startCommentId, "offset" to offset, "count" to count, "sort" to sort, "access_key" to accessKey, "extended" to extended, "fields" to fields))
        return GetCommentsResponse(response, json)
    }
    class GetCommentsResponse(
        private val rawResponse: String, json: Json
    ): BaseMultivariateResponse(json) {
        fun PhotosGetCommentsExtendedResponse(): PhotosGetCommentsExtendedResponse? {
            return getResponseOrNull(PhotosGetCommentsExtendedResponse.serializer(), rawResponse)
        }
        fun PhotosGetCommentsResponse(): PhotosGetCommentsResponse? {
            return getResponseOrNull(PhotosGetCommentsResponse.serializer(), rawResponse)
        }
    }

    /**
     *
     * Returns the server address for market album photo upload.
     * 
     * @param groupId Community ID.
     */
    suspend fun getMarketAlbumUploadServer(groupId: Int): BaseGetUploadServerResponse {
        val response = method("photos.getMarketAlbumUploadServer", mapOf("group_id" to groupId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns the server address for market photo upload.
     * 
     * @param groupId Community ID.
     * @param mainPhoto '1' if you want to upload the main item photo.
     * @param cropX X coordinate of the crop left upper corner.
     * @param cropY Y coordinate of the crop left upper corner.
     * @param cropWidth Width of the cropped photo in px.
     */
    suspend fun getMarketUploadServer(groupId: Int, mainPhoto: Boolean? = false, cropX: Int? = null, cropY: Int? = null, cropWidth: Int? = null): PhotosGetMarketUploadServerResponse {
        val response = method("photos.getMarketUploadServer", mapOf("group_id" to groupId, "main_photo" to mainPhoto, "crop_x" to cropX, "crop_y" to cropY, "crop_width" to cropWidth))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns the server address for photo upload in a private message for a user.
     * 
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'Chat ID', e.g. '2000000001'. For community: '- Community ID', e.g. '-12345'. ".
     */
    suspend fun getMessagesUploadServer(peerId: Int? = null): PhotosGetMessagesUploadServerResponse {
        val response = method("photos.getMessagesUploadServer", mapOf("peer_id" to peerId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of photos with tags that have not been viewed.
     * 
     * @param offset Offset needed to return a specific subset of photos.
     * @param count Number of photos to return.
     */
    suspend fun getNewTags(offset: Int? = null, count: Int? = 20): PhotosGetNewTagsResponse {
        val response = method("photos.getNewTags", mapOf("offset" to offset, "count" to count))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns the server address for owner cover upload.
     * 
     * @param groupId ID of community that owns the album (if the photo will be uploaded to a community album).
     * @param cropX X coordinate of the left-upper corner.
     * @param cropY Y coordinate of the left-upper corner.
     * @param cropX2 X coordinate of the right-bottom corner.
     * @param cropY2 Y coordinate of the right-bottom corner.
     * @param isVideoCover 
     */
    suspend fun getOwnerCoverPhotoUploadServer(groupId: Int? = null, cropX: Int? = 0, cropY: Int? = 0, cropX2: Int? = 795, cropY2: Int? = 200, isVideoCover: Boolean? = false): BaseGetUploadServerResponse {
        val response = method("photos.getOwnerCoverPhotoUploadServer", mapOf("group_id" to groupId, "crop_x" to cropX, "crop_y" to cropY, "crop_x2" to cropX2, "crop_y2" to cropY2, "is_video_cover" to isVideoCover))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns an upload server address for a profile or community photo.
     * 
     * @param ownerId identifier of a community or current user. "Note that community id must be negative. 'owner_id=1' - user, 'owner_id=-1' - community, ".
     */
    suspend fun getOwnerPhotoUploadServer(ownerId: Int? = null): BaseGetUploadServerResponse {
        val response = method("photos.getOwnerPhotoUploadServer", mapOf("owner_id" to ownerId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of tags on a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param accessKey 
     */
    suspend fun getTags(photoId: Int, ownerId: Int? = null, accessKey: String? = null): PhotosGetTagsResponse {
        val response = method("photos.getTags", mapOf("owner_id" to ownerId, "photo_id" to photoId, "access_key" to accessKey))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns the server address for photo upload.
     * 
     * @param albumId 
     * @param groupId ID of community that owns the album (if the photo will be uploaded to a community album).
     */
    suspend fun getUploadServer(albumId: Int? = null, groupId: Int? = null): PhotosGetUploadServerResponse {
        val response = method("photos.getUploadServer", mapOf("album_id" to albumId, "group_id" to groupId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of photos in which a user is tagged.
     * 
     * @param userId User ID.
     * @param offset Offset needed to return a specific subset of photos. By default, '0'.
     * @param count Number of photos to return. Maximum value is 1000.
     * @param extended '1' - to return an additional 'likes' field, '0' - (default).
     * @param sort Sort order: '1' - by date the tag was added in ascending order, '0' - by date the tag was added in descending order.
     */
    suspend fun getUserPhotos(userId: Int? = null, offset: Int? = null, count: Int? = 20, extended: Boolean? = false, sort: String? = null): PhotosGetUserPhotosResponse {
        val response = method("photos.getUserPhotos", mapOf("user_id" to userId, "offset" to offset, "count" to count, "extended" to extended, "sort" to sort))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns the server address for photo upload onto a user's wall.
     * 
     * @param groupId ID of community to whose wall the photo will be uploaded.
     */
    suspend fun getWallUploadServer(groupId: Int? = null): PhotosGetWallUploadServerResponse {
        val response = method("photos.getWallUploadServer", mapOf("group_id" to groupId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Makes a photo into an album cover.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param albumId Album ID.
     */
    suspend fun makeCover(photoId: Int, ownerId: Int? = null, albumId: Int? = null): BaseOkResponse {
        val response = method("photos.makeCover", mapOf("owner_id" to ownerId, "photo_id" to photoId, "album_id" to albumId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Moves a photo from one album to another.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param targetAlbumId ID of the album to which the photo will be moved.
     * @param photoIds 
     */
    suspend fun move(targetAlbumId: Int, photoIds: List<Int>, ownerId: Int? = null): BaseOkResponse {
        val response = method("photos.move", mapOf("owner_id" to ownerId, "target_album_id" to targetAlbumId, "photo_ids" to photoIds))
        return decodeResponse(response, json)
    }

    /**
     *
     * Adds a tag on the photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param userId ID of the user to be tagged.
     * @param x Upper left-corner coordinate of the tagged area (as a percentage of the photo's width).
     * @param y Upper left-corner coordinate of the tagged area (as a percentage of the photo's height).
     * @param x2 Lower right-corner coordinate of the tagged area (as a percentage of the photo's width).
     * @param y2 Lower right-corner coordinate of the tagged area (as a percentage of the photo's height).
     */
    suspend fun putTag(photoId: Int, userId: Int, ownerId: Int? = null, x: Double? = null, y: Double? = null, x2: Double? = null, y2: Double? = null): PhotosPutTagResponse {
        val response = method("photos.putTag", mapOf("owner_id" to ownerId, "photo_id" to photoId, "user_id" to userId, "x" to x, "y" to y, "x2" to x2, "y2" to y2))
        return decodeResponse(response, json)
    }

    /**
     *
     * Removes a tag from a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param tagId Tag ID.
     */
    suspend fun removeTag(photoId: Int, tagId: Int, ownerId: Int? = null): BaseOkResponse {
        val response = method("photos.removeTag", mapOf("owner_id" to ownerId, "photo_id" to photoId, "tag_id" to tagId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Reorders the album in the list of user albums.
     * 
     * @param ownerId ID of the user or community that owns the album.
     * @param albumId Album ID.
     * @param before ID of the album before which the album in question shall be placed.
     * @param after ID of the album after which the album in question shall be placed.
     */
    suspend fun reorderAlbums(albumId: Int, ownerId: Int? = null, before: Int? = null, after: Int? = null): BaseOkResponse {
        val response = method("photos.reorderAlbums", mapOf("owner_id" to ownerId, "album_id" to albumId, "before" to before, "after" to after))
        return decodeResponse(response, json)
    }

    /**
     *
     * Reorders the photo in the list of photos of the user album.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param before ID of the photo before which the photo in question shall be placed.
     * @param after ID of the photo after which the photo in question shall be placed.
     */
    suspend fun reorderPhotos(photoId: Int, ownerId: Int? = null, before: Int? = null, after: Int? = null): BaseOkResponse {
        val response = method("photos.reorderPhotos", mapOf("owner_id" to ownerId, "photo_id" to photoId, "before" to before, "after" to after))
        return decodeResponse(response, json)
    }

    /**
     *
     * Reports (submits a complaint about) a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     * @param reason Reason for the complaint: '0' - spam, '1' - child pornography, '2' - extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse, '8' - suicide calls.
     */
    suspend fun report(ownerId: Int, photoId: Int, reason: Int? = null): BaseOkResponse {
        val response = method("photos.report", mapOf("owner_id" to ownerId, "photo_id" to photoId, "reason" to reason))
        return decodeResponse(response, json)
    }

    /**
     *
     * Reports (submits a complaint about) a comment on a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param commentId ID of the comment being reported.
     * @param reason Reason for the complaint: '0' - spam, '1' - child pornography, '2' - extremism, '3' - violence, '4' - drug propaganda, '5' - adult material, '6' - insult, abuse.
     */
    suspend fun reportComment(ownerId: Int, commentId: Int, reason: Int? = null): BaseOkResponse {
        val response = method("photos.reportComment", mapOf("owner_id" to ownerId, "comment_id" to commentId, "reason" to reason))
        return decodeResponse(response, json)
    }

    /**
     *
     * Restores a deleted photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param photoId Photo ID.
     */
    suspend fun restore(photoId: Int, ownerId: Int? = null): BaseOkResponse {
        val response = method("photos.restore", mapOf("owner_id" to ownerId, "photo_id" to photoId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Restores a deleted comment on a photo.
     * 
     * @param ownerId ID of the user or community that owns the photo.
     * @param commentId ID of the deleted comment.
     */
    suspend fun restoreComment(commentId: Int, ownerId: Int? = null): BaseBoolResponse {
        val response = method("photos.restoreComment", mapOf("owner_id" to ownerId, "comment_id" to commentId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves photos after successful uploading.
     * 
     * @param albumId ID of the album to save photos to.
     * @param groupId ID of the community to save photos to.
     * @param server Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param photosList Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param hash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param latitude Geographical latitude, in degrees (from '-90' to '90').
     * @param longitude Geographical longitude, in degrees (from '-180' to '180').
     * @param caption Text describing the photo. 2048 digits max.
     */
    suspend fun save(albumId: Int? = null, groupId: Int? = null, server: Int? = null, photosList: String? = null, hash: String? = null, latitude: Double? = null, longitude: Double? = null, caption: String? = null): PhotosSaveResponse {
        val response = method("photos.save", mapOf("album_id" to albumId, "group_id" to groupId, "server" to server, "photos_list" to photosList, "hash" to hash, "latitude" to latitude, "longitude" to longitude, "caption" to caption))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves market album photos after successful uploading.
     * 
     * @param groupId Community ID.
     * @param photo Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param server Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param hash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     */
    suspend fun saveMarketAlbumPhoto(groupId: Int, photo: String, server: Int, hash: String): PhotosSaveMarketAlbumPhotoResponse {
        val response = method("photos.saveMarketAlbumPhoto", mapOf("group_id" to groupId, "photo" to photo, "server" to server, "hash" to hash))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves market photos after successful uploading.
     * 
     * @param groupId Community ID.
     * @param photo Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param server Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param hash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param cropData Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param cropHash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     */
    suspend fun saveMarketPhoto(photo: String, server: Int, hash: String, groupId: Int? = null, cropData: String? = null, cropHash: String? = null): PhotosSaveMarketPhotoResponse {
        val response = method("photos.saveMarketPhoto", mapOf("group_id" to groupId, "photo" to photo, "server" to server, "hash" to hash, "crop_data" to cropData, "crop_hash" to cropHash))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves a photo after being successfully uploaded. URL obtained with [vk.com/dev/photos.getMessagesUploadServer|photos.getMessagesUploadServer] method.
     * 
     * @param photo Parameter returned when the photo is [vk.com/dev/upload_files|uploaded to the server].
     * @param server 
     * @param hash 
     */
    suspend fun saveMessagesPhoto(photo: String, server: Int? = null, hash: String? = null): PhotosSaveMessagesPhotoResponse {
        val response = method("photos.saveMessagesPhoto", mapOf("photo" to photo, "server" to server, "hash" to hash))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves cover photo after successful uploading.
     * 
     * @param cropX 
     * @param cropHeight 
     * @param cropY 
     * @param cropWidth 
     * @param responseJson 
     * @param hash Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param photo Parameter returned when photos are [vk.com/dev/upload_files|uploaded to server].
     * @param isVideoCover 
     */
    suspend fun saveOwnerCoverPhoto(cropX: Int? = 0, cropHeight: Int? = 0, cropY: Int? = 0, cropWidth: Int? = 0, responseJson: String? = null, hash: String? = null, photo: String? = null, isVideoCover: Boolean? = false): PhotosSaveOwnerCoverPhotoResponse {
        val response = method("photos.saveOwnerCoverPhoto", mapOf("crop_x" to cropX, "crop_height" to cropHeight, "crop_y" to cropY, "crop_width" to cropWidth, "response_json" to responseJson, "hash" to hash, "photo" to photo, "is_video_cover" to isVideoCover))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves a profile or community photo. Upload URL can be got with the [vk.com/dev/photos.getOwnerPhotoUploadServer|photos.getOwnerPhotoUploadServer] method.
     * 
     * @param server parameter returned after [vk.com/dev/upload_files|photo upload].
     * @param hash parameter returned after [vk.com/dev/upload_files|photo upload].
     * @param photo parameter returned after [vk.com/dev/upload_files|photo upload].
     */
    suspend fun saveOwnerPhoto(server: String? = null, hash: String? = null, photo: String? = null): PhotosSaveOwnerPhotoResponse {
        val response = method("photos.saveOwnerPhoto", mapOf("server" to server, "hash" to hash, "photo" to photo))
        return decodeResponse(response, json)
    }

    /**
     *
     * Saves a photo to a user's or community's wall after being uploaded.
     * 
     * @param userId ID of the user on whose wall the photo will be saved.
     * @param groupId ID of community on whose wall the photo will be saved.
     * @param photo Parameter returned when the the photo is [vk.com/dev/upload_files|uploaded to the server].
     * @param server 
     * @param hash 
     * @param latitude Geographical latitude, in degrees (from '-90' to '90').
     * @param longitude Geographical longitude, in degrees (from '-180' to '180').
     * @param caption Text describing the photo. 2048 digits max.
     */
    suspend fun saveWallPhoto(photo: String, userId: Int? = null, groupId: Int? = null, server: Int? = null, hash: String? = null, latitude: Double? = null, longitude: Double? = null, caption: String? = null): PhotosSaveWallPhotoResponse {
        val response = method("photos.saveWallPhoto", mapOf("user_id" to userId, "group_id" to groupId, "photo" to photo, "server" to server, "hash" to hash, "latitude" to latitude, "longitude" to longitude, "caption" to caption))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of photos.
     * 
     * @param q Search query string.
     * @param lat Geographical latitude, in degrees (from '-90' to '90').
     * @param long Geographical longitude, in degrees (from '-180' to '180').
     * @param startTime 
     * @param endTime 
     * @param sort Sort order:.
     * @param offset Offset needed to return a specific subset of photos.
     * @param count Number of photos to return.
     * @param radius Radius of search in meters (works very approximately). Available values: '10', '100', '800', '6000', '50000'.
     */
    suspend fun search(q: String? = null, lat: Double? = null, long: Double? = null, startTime: Int? = null, endTime: Int? = null, sort: Int? = null, offset: Int? = null, count: Int? = 100, radius: Int? = 5000): PhotosSearchResponse {
        val response = method("photos.search", mapOf("q" to q, "lat" to lat, "long" to long, "start_time" to startTime, "end_time" to endTime, "sort" to sort, "offset" to offset, "count" to count, "radius" to radius))
        return decodeResponse(response, json)
    }

}
