package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.adsweb.*
import kotlinx.serialization.json.Json

class Adsweb(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param officeId 
     */
    suspend fun getAdCategories(officeId: Long): AdswebGetAdCategoriesResponse {
        val response = method("getAdCategories", mapOf("office_id" to officeId))
        return json.decodeFromString<AdswebGetAdCategoriesResponse>(response)
    }

    /**
     *
     */
    suspend fun getAdUnitCode(): AdswebGetAdUnitCodeResponse {
        val response = method("getAdUnitCode", mapOf())
        return json.decodeFromString<AdswebGetAdUnitCodeResponse>(response)
    }

    /**
     *
     * @param officeId 
     * @param sitesIds 
     * @param adUnitsIds 
     * @param fields 
     * @param limit 
     * @param offset 
     */
    suspend fun getAdUnits(officeId: Long, sitesIds: String? = null, adUnitsIds: String? = null, fields: String? = null, limit: Int? = null, offset: Int? = 0): AdswebGetAdUnitsResponse {
        val response = method("getAdUnits", mapOf("office_id" to officeId, "sites_ids" to sitesIds, "ad_units_ids" to adUnitsIds, "fields" to fields, "limit" to limit, "offset" to offset))
        return json.decodeFromString<AdswebGetAdUnitsResponse>(response)
    }

    /**
     *
     * @param officeId 
     * @param sitesIds 
     * @param limit 
     * @param offset 
     */
    suspend fun getFraudHistory(officeId: Long, sitesIds: String? = null, limit: Int? = null, offset: Int? = 0): AdswebGetFraudHistoryResponse {
        val response = method("getFraudHistory", mapOf("office_id" to officeId, "sites_ids" to sitesIds, "limit" to limit, "offset" to offset))
        return json.decodeFromString<AdswebGetFraudHistoryResponse>(response)
    }

    /**
     *
     * @param officeId 
     * @param sitesIds 
     * @param fields 
     * @param limit 
     * @param offset 
     */
    suspend fun getSites(officeId: Long, sitesIds: String? = null, fields: String? = null, limit: Int? = null, offset: Int? = 0): AdswebGetSitesResponse {
        val response = method("getSites", mapOf("office_id" to officeId, "sites_ids" to sitesIds, "fields" to fields, "limit" to limit, "offset" to offset))
        return json.decodeFromString<AdswebGetSitesResponse>(response)
    }

    /**
     *
     * @param officeId 
     * @param idsType 
     * @param ids 
     * @param period 
     * @param dateFrom 
     * @param dateTo 
     * @param fields 
     * @param limit 
     * @param pageId 
     */
    suspend fun getStatistics(officeId: Long, idsType: String, ids: String, period: String, dateFrom: String, dateTo: String, fields: String? = null, limit: Int? = null, pageId: String? = null): AdswebGetStatisticsResponse {
        val response = method("getStatistics", mapOf("office_id" to officeId, "ids_type" to idsType, "ids" to ids, "period" to period, "date_from" to dateFrom, "date_to" to dateTo, "fields" to fields, "limit" to limit, "page_id" to pageId))
        return json.decodeFromString<AdswebGetStatisticsResponse>(response)
    }

}
