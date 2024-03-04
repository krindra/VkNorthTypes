package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.utils.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Utils(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Checks whether a link is blocked in VK.
     * 
     * @param url Link to check (e.g., 'http://google.com').
     */
    suspend fun checkLink(url: String): UtilsCheckLinkResponse {
        val response = method("checkLink", mapOf("url" to url))
        return json.decodeFromString<UtilsCheckLinkResponse>(response)
    }

    /**
     *
     * Deletes shortened link from user's list.
     * 
     * @param key Link key (characters after vk.cc/).
     */
    suspend fun deleteFromLastShortened(key: String): BaseOkResponse {
        val response = method("deleteFromLastShortened", mapOf("key" to key))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns a list of user's shortened links.
     * 
     * @param count Number of links to return.
     * @param offset Offset needed to return a specific subset of links.
     */
    suspend fun getLastShortenedLinks(count: Int? = 10, offset: Int? = 0): UtilsGetLastShortenedLinksResponse {
        val response = method("getLastShortenedLinks", mapOf("count" to count, "offset" to offset))
        return json.decodeFromString<UtilsGetLastShortenedLinksResponse>(response)
    }

    /**
     *
     * Returns stats data for shortened link.
     * 
     * @param key Link key (characters after vk.cc/).
     * @param source Source of scope.
     * @param accessKey Access key for private link stats.
     * @param interval Interval.
     * @param intervalsCount Number of intervals to return.
     * @param extended 1 - to return extended stats data (sex, age, geo). 0 - to return views number only.
     */
    suspend fun getLinkStats(key: String, source: String? = "vk_cc", accessKey: String? = null, interval: String? = "day", intervalsCount: Int? = 1, extended: Boolean? = false): GetlinkstatsResponse {
        val response = method("getLinkStats", mapOf("key" to key, "source" to source, "access_key" to accessKey, "interval" to interval, "intervals_count" to intervalsCount, "extended" to extended))
        return GetlinkstatsResponse(response, json)
    }
    class GetlinkstatsResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(UtilsGetLinkStatsExtendedResponse.serializer(), UtilsGetLinkStatsResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun UtilsGetLinkStatsExtendedResponse(): UtilsGetLinkStatsExtendedResponse?{
            return if (response is UtilsGetLinkStatsExtendedResponse) response else null
        }
        fun UtilsGetLinkStatsResponse(): UtilsGetLinkStatsResponse?{
            return if (response is UtilsGetLinkStatsResponse) response else null
        }
    }

    /**
     *
     * Returns the current time of the VK server.
     * 
     */
    suspend fun getServerTime(): UtilsGetServerTimeResponse {
        val response = method("getServerTime", mapOf())
        return json.decodeFromString<UtilsGetServerTimeResponse>(response)
    }

    /**
     *
     * Allows to receive a link shortened via vk.cc.
     * 
     * @param url URL to be shortened.
     * @param private 1 - private stats, 0 - public stats.
     */
    suspend fun getShortLink(url: String, private: Boolean? = false): UtilsGetShortLinkResponse {
        val response = method("getShortLink", mapOf("url" to url, "private" to private))
        return json.decodeFromString<UtilsGetShortLinkResponse>(response)
    }

    /**
     *
     * Detects a type of object (e.g., user, community, application) and its ID by screen name.
     * 
     * @param screenName Screen name of the user, community (e.g., 'apiclub,' 'andrew', or 'rules_of_war'), or application.
     */
    suspend fun resolveScreenName(screenName: String): UtilsResolveScreenNameResponse {
        val response = method("resolveScreenName", mapOf("screen_name" to screenName))
        return json.decodeFromString<UtilsResolveScreenNameResponse>(response)
    }

}
