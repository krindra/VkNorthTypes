package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.docs.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.types.base.BaseGetUploadServerResponse

class Docs(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Copies a document to a user's or community's document list.
     * 
     * @param ownerId ID of the user or community that owns the document. Use a negative value to designate a community ID.
     * @param docId Document ID.
     * @param accessKey Access key. This parameter is required if 'access_key' was returned with the document's data.
     */
    suspend fun add(ownerId: Long, docId: Long, accessKey: String? = null): DocsAddResponse {
        val response = method("add", mapOf("owner_id" to ownerId, "doc_id" to docId, "access_key" to accessKey))
        return json.decodeFromString<DocsAddResponse>(response)
    }

    /**
     *
     * Deletes a user or community document.
     * 
     * @param ownerId ID of the user or community that owns the document. Use a negative value to designate a community ID.
     * @param docId Document ID.
     */
    suspend fun delete(ownerId: Long, docId: Long): BaseOkResponse {
        val response = method("delete", mapOf("owner_id" to ownerId, "doc_id" to docId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits a document.
     * 
     * @param ownerId User ID or community ID. Use a negative value to designate a community ID.
     * @param docId Document ID.
     * @param title Document title.
     * @param tags Document tags.
     */
    suspend fun edit(docId: Long, title: String, ownerId: Long? = null, tags: List<String>? = null): BaseOkResponse {
        val response = method("edit", mapOf("owner_id" to ownerId, "doc_id" to docId, "title" to title, "tags" to tags))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns detailed information about user or community documents.
     * 
     * @param count Number of documents to return. By default, all documents.
     * @param offset Offset needed to return a specific subset of documents.
     * @param type 
     * @param ownerId ID of the user or community that owns the documents. Use a negative value to designate a community ID.
     * @param returnTags 
     */
    suspend fun get(count: Int? = null, offset: Int? = null, type: Int? = 0, ownerId: Long? = null, returnTags: Boolean? = false): DocsGetResponse {
        val response = method("get", mapOf("count" to count, "offset" to offset, "type" to type, "owner_id" to ownerId, "return_tags" to returnTags))
        return json.decodeFromString<DocsGetResponse>(response)
    }

    /**
     *
     * Returns information about documents by their IDs.
     * 
     * @param docs Document IDs. Example: , "66748_91488,66748_91455",.
     * @param returnTags 
     */
    suspend fun getById(docs: List<String>, returnTags: Boolean? = false): DocsGetByIdResponse {
        val response = method("getById", mapOf("docs" to docs, "return_tags" to returnTags))
        return json.decodeFromString<DocsGetByIdResponse>(response)
    }

    /**
     *
     * Returns the server address for document upload.
     * 
     * @param type Document type.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'Chat ID', e.g. '2000000001'. For community: '- Community ID', e.g. '-12345'. ".
     */
    suspend fun getMessagesUploadServer(type: String? = "doc", peerId: Long? = null): DocsGetUploadServerResponse {
        val response = method("getMessagesUploadServer", mapOf("type" to type, "peer_id" to peerId))
        return json.decodeFromString<DocsGetUploadServerResponse>(response)
    }

    /**
     *
     * Returns documents types available for current user.
     * 
     * @param ownerId ID of the user or community that owns the documents. Use a negative value to designate a community ID.
     */
    suspend fun getTypes(ownerId: Long? = null): DocsGetTypesResponse {
        val response = method("getTypes", mapOf("owner_id" to ownerId))
        return json.decodeFromString<DocsGetTypesResponse>(response)
    }

    /**
     *
     * Returns the server address for document upload.
     * 
     * @param groupId Community ID (if the document will be uploaded to the community).
     */
    suspend fun getUploadServer(groupId: Long? = null): DocsGetUploadServerResponse {
        val response = method("getUploadServer", mapOf("group_id" to groupId))
        return json.decodeFromString<DocsGetUploadServerResponse>(response)
    }

    /**
     *
     * Returns the server address for document upload onto a user's or community's wall.
     * 
     * @param groupId Community ID (if the document will be uploaded to the community).
     */
    suspend fun getWallUploadServer(groupId: Long? = null): BaseGetUploadServerResponse {
        val response = method("getWallUploadServer", mapOf("group_id" to groupId))
        return json.decodeFromString<BaseGetUploadServerResponse>(response)
    }

    /**
     *
     * Saves a document after [vk.com/dev/upload_files_2|uploading it to a server].
     * 
     * @param file This parameter is returned when the file is [vk.com/dev/upload_files_2|uploaded to the server].
     * @param title Document title.
     * @param tags Document tags.
     * @param returnTags 
     */
    suspend fun save(file: String, title: String? = null, tags: String? = null, returnTags: Boolean? = false): DocsSaveResponse {
        val response = method("save", mapOf("file" to file, "title" to title, "tags" to tags, "return_tags" to returnTags))
        return json.decodeFromString<DocsSaveResponse>(response)
    }

    /**
     *
     * Returns a list of documents matching the search criteria.
     * 
     * @param q Search query string.
     * @param searchOwn 
     * @param count Number of results to return.
     * @param offset Offset needed to return a specific subset of results.
     * @param returnTags 
     */
    suspend fun search(q: String? = null, searchOwn: Boolean? = false, count: Int? = 20, offset: Int? = null, returnTags: Boolean? = false): DocsSearchResponse {
        val response = method("search", mapOf("q" to q, "search_own" to searchOwn, "count" to count, "offset" to offset, "return_tags" to returnTags))
        return json.decodeFromString<DocsSearchResponse>(response)
    }

}
