package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.notes.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Notes(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Creates a new note for the current user.
     * 
     * @param title Note title.
     * @param text Note text.
     * @param privacyView 
     * @param privacyComment 
     */
    suspend fun add(title: String, text: String, privacyView: List<String>? = listOf("all"), privacyComment: List<String>? = listOf("all")): NotesAddResponse {
        val response = method("add", mapOf("title" to title, "text" to text, "privacy_view" to privacyView, "privacy_comment" to privacyComment))
        return json.decodeFromString<NotesAddResponse>(response)
    }

    /**
     *
     * Adds a new comment on a note.
     * 
     * @param noteId Note ID.
     * @param ownerId Note owner ID.
     * @param replyTo ID of the user to whom the reply is addressed (if the comment is a reply to another comment).
     * @param message Comment text.
     * @param guid 
     */
    suspend fun createComment(noteId: Long, message: String, ownerId: Long? = null, replyTo: Int? = null, guid: String? = null): NotesCreateCommentResponse {
        val response = method("createComment", mapOf("note_id" to noteId, "owner_id" to ownerId, "reply_to" to replyTo, "message" to message, "guid" to guid))
        return json.decodeFromString<NotesCreateCommentResponse>(response)
    }

    /**
     *
     * Deletes a note of the current user.
     * 
     * @param noteId Note ID.
     */
    suspend fun delete(noteId: Long): BaseOkResponse {
        val response = method("delete", mapOf("note_id" to noteId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Deletes a comment on a note.
     * 
     * @param commentId Comment ID.
     * @param ownerId Note owner ID.
     */
    suspend fun deleteComment(commentId: Long, ownerId: Long? = null): BaseOkResponse {
        val response = method("deleteComment", mapOf("comment_id" to commentId, "owner_id" to ownerId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits a note of the current user.
     * 
     * @param noteId Note ID.
     * @param title Note title.
     * @param text Note text.
     * @param privacyView 
     * @param privacyComment 
     */
    suspend fun edit(noteId: Long, title: String, text: String, privacyView: List<String>? = listOf("all"), privacyComment: List<String>? = listOf("all")): BaseOkResponse {
        val response = method("edit", mapOf("note_id" to noteId, "title" to title, "text" to text, "privacy_view" to privacyView, "privacy_comment" to privacyComment))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits a comment on a note.
     * 
     * @param commentId Comment ID.
     * @param ownerId Note owner ID.
     * @param message New comment text.
     */
    suspend fun editComment(commentId: Long, message: String, ownerId: Long? = null): BaseOkResponse {
        val response = method("editComment", mapOf("comment_id" to commentId, "owner_id" to ownerId, "message" to message))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns a list of notes created by a user.
     * 
     * @param noteIds Note IDs.
     * @param userId Note owner ID.
     * @param offset 
     * @param count Number of notes to return.
     * @param sort 
     */
    suspend fun get(noteIds: List<Int>? = null, userId: Long? = null, offset: Int? = 0, count: Int? = 20, sort: Int? = 0): NotesGetResponse {
        val response = method("get", mapOf("note_ids" to noteIds, "user_id" to userId, "offset" to offset, "count" to count, "sort" to sort))
        return json.decodeFromString<NotesGetResponse>(response)
    }

    /**
     *
     * Returns a note by its ID.
     * 
     * @param noteId Note ID.
     * @param ownerId Note owner ID.
     * @param needWiki 
     */
    suspend fun getById(noteId: Long, ownerId: Long? = null, needWiki: Boolean? = false): NotesGetByIdResponse {
        val response = method("getById", mapOf("note_id" to noteId, "owner_id" to ownerId, "need_wiki" to needWiki))
        return json.decodeFromString<NotesGetByIdResponse>(response)
    }

    /**
     *
     * Returns a list of comments on a note.
     * 
     * @param noteId Note ID.
     * @param ownerId Note owner ID.
     * @param sort 
     * @param offset 
     * @param count Number of comments to return.
     */
    suspend fun getComments(noteId: Long, ownerId: Long? = null, sort: Int? = 0, offset: Int? = 0, count: Int? = 20): NotesGetCommentsResponse {
        val response = method("getComments", mapOf("note_id" to noteId, "owner_id" to ownerId, "sort" to sort, "offset" to offset, "count" to count))
        return json.decodeFromString<NotesGetCommentsResponse>(response)
    }

    /**
     *
     * Restores a deleted comment on a note.
     * 
     * @param commentId Comment ID.
     * @param ownerId Note owner ID.
     */
    suspend fun restoreComment(commentId: Long, ownerId: Long? = null): BaseOkResponse {
        val response = method("restoreComment", mapOf("comment_id" to commentId, "owner_id" to ownerId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
