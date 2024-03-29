package ru.krindra.vknorthtypes.methods

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********


import ru.krindra.vknorthtypes.types.pages.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Pages(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Allows to clear the cache of particular 'external' pages which may be attached to VK posts.
     * 
     * @param url Address of the page where you need to refesh the cached version.
     */
    suspend fun clearCache(url: String): BaseOkResponse {
        val response = method("clearCache", mapOf("url" to url))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns information about a wiki page.
     * 
     * @param ownerId Page owner ID.
     * @param pageId Wiki page ID.
     * @param global_ '1' - to return information about a global wiki page.
     * @param sitePreview '1' - resulting wiki page is a preview for the attached link.
     * @param title Wiki page title.
     * @param needSource 
     * @param needHtml '1' - to return the page as HTML,.
     */
    suspend fun get(ownerId: Long? = null, pageId: Long? = null, global_: Boolean? = false, sitePreview: Boolean? = false, title: String? = null, needSource: Boolean? = false, needHtml: Boolean? = false): PagesGetResponse {
        val response = method("get", mapOf("owner_id" to ownerId, "page_id" to pageId, "global_" to global_, "site_preview" to sitePreview, "title" to title, "need_source" to needSource, "need_html" to needHtml))
        return json.decodeFromString<PagesGetResponse>(response)
    }

    /**
     *
     * Returns a list of all previous versions of a wiki page.
     * 
     * @param pageId Wiki page ID.
     * @param groupId ID of the community that owns the wiki page.
     * @param userId 
     */
    suspend fun getHistory(pageId: Long, groupId: Long? = null, userId: Long? = null): PagesGetHistoryResponse {
        val response = method("getHistory", mapOf("page_id" to pageId, "group_id" to groupId, "user_id" to userId))
        return json.decodeFromString<PagesGetHistoryResponse>(response)
    }

    /**
     *
     * Returns a list of wiki pages in a group.
     * 
     * @param groupId ID of the community that owns the wiki page.
     */
    suspend fun getTitles(groupId: Long? = null): PagesGetTitlesResponse {
        val response = method("getTitles", mapOf("group_id" to groupId))
        return json.decodeFromString<PagesGetTitlesResponse>(response)
    }

    /**
     *
     * Returns the text of one of the previous versions of a wiki page.
     * 
     * @param versionId 
     * @param groupId ID of the community that owns the wiki page.
     * @param userId 
     * @param needHtml '1' - to return the page as HTML.
     */
    suspend fun getVersion(versionId: Long, groupId: Long? = null, userId: Long? = null, needHtml: Boolean? = false): PagesGetVersionResponse {
        val response = method("getVersion", mapOf("version_id" to versionId, "group_id" to groupId, "user_id" to userId, "need_html" to needHtml))
        return json.decodeFromString<PagesGetVersionResponse>(response)
    }

    /**
     *
     * Returns HTML representation of the wiki markup.
     * 
     * @param text Text of the wiki page.
     * @param groupId ID of the group in the context of which this markup is interpreted.
     */
    suspend fun parseWiki(text: String, groupId: Long? = null): PagesParseWikiResponse {
        val response = method("parseWiki", mapOf("text" to text, "group_id" to groupId))
        return json.decodeFromString<PagesParseWikiResponse>(response)
    }

    /**
     *
     * Saves the text of a wiki page.
     * 
     * @param text Text of the wiki page in wiki-format.
     * @param pageId Wiki page ID. The 'title' parameter can be passed instead of 'pid'.
     * @param groupId ID of the community that owns the wiki page.
     * @param userId User ID.
     * @param title Wiki page title.
     */
    suspend fun save(text: String? = null, pageId: Long? = null, groupId: Long? = null, userId: Long? = null, title: String? = null): PagesSaveResponse {
        val response = method("save", mapOf("text" to text, "page_id" to pageId, "group_id" to groupId, "user_id" to userId, "title" to title))
        return json.decodeFromString<PagesSaveResponse>(response)
    }

    /**
     *
     * Saves modified read and edit access settings for a wiki page.
     * 
     * @param pageId Wiki page ID.
     * @param groupId ID of the community that owns the wiki page.
     * @param userId 
     * @param view Who can view the wiki page: '1' - only community members, '2' - all users can view the page, '0' - only community managers.
     * @param edit Who can edit the wiki page: '1' - only community members, '2' - all users can edit the page, '0' - only community managers.
     */
    suspend fun saveAccess(pageId: Long, groupId: Long? = null, userId: Long? = null, view: Int? = null, edit: Int? = null): PagesSaveAccessResponse {
        val response = method("saveAccess", mapOf("page_id" to pageId, "group_id" to groupId, "user_id" to userId, "view" to view, "edit" to edit))
        return json.decodeFromString<PagesSaveAccessResponse>(response)
    }

}
