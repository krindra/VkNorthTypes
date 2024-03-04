package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.stats.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Stats(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Returns statistics of a community or an application.
     * 
     * @param groupId Community ID.
     * @param appId Application ID.
     * @param timestampFrom 
     * @param timestampTo 
     * @param interval 
     * @param intervalsCount 
     * @param filters 
     * @param statsGroups 
     * @param extended 
     */
    suspend fun get(groupId: Long? = null, appId: Long? = null, timestampFrom: Int? = null, timestampTo: Int? = null, interval: String? = "day", intervalsCount: Int? = null, filters: List<String>? = null, statsGroups: List<String>? = null, extended: Boolean? = true): StatsGetResponse {
        val response = method("get", mapOf("group_id" to groupId, "app_id" to appId, "timestamp_from" to timestampFrom, "timestamp_to" to timestampTo, "interval" to interval, "intervals_count" to intervalsCount, "filters" to filters, "stats_groups" to statsGroups, "extended" to extended))
        return json.decodeFromString<StatsGetResponse>(response)
    }

    /**
     *
     * Returns stats for a wall post.
     * 
     * @param ownerId post owner community id. Specify with "-" sign.
     * @param postIds wall posts id.
     */
    suspend fun getPostReach(ownerId: Long, postIds: List<Int>): StatsGetPostReachResponse {
        val response = method("getPostReach", mapOf("owner_id" to ownerId, "post_ids" to postIds))
        return json.decodeFromString<StatsGetPostReachResponse>(response)
    }

    /**
     *
     */
    suspend fun trackVisitor(): BaseOkResponse {
        val response = method("trackVisitor", mapOf())
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
