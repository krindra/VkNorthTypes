package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param viewsAdsTimes1 
 * @param viewsAdsTimes2 
 * @param viewsAdsTimes3 
 * @param viewsAdsTimes4 
 * @param viewsAdsTimes5 
 * @param viewsAdsTimes6 
 * @param viewsAdsTimes7 
 * @param viewsAdsTimes8 
 * @param viewsAdsTimes9 
 * @param viewsAdsTimes10 
 * @param viewsAdsTimes11Plus 
 */
@Serializable
data class AdsStatsViewsTimes (
    @SerialName("views_ads_times_1") val viewsAdsTimes1: Int? = null,
    @SerialName("views_ads_times_2") val viewsAdsTimes2: Int? = null,
    @SerialName("views_ads_times_3") val viewsAdsTimes3: Int? = null,
    @SerialName("views_ads_times_4") val viewsAdsTimes4: Int? = null,
    @SerialName("views_ads_times_6") val viewsAdsTimes6: Int? = null,
    @SerialName("views_ads_times_7") val viewsAdsTimes7: Int? = null,
    @SerialName("views_ads_times_8") val viewsAdsTimes8: Int? = null,
    @SerialName("views_ads_times_9") val viewsAdsTimes9: Int? = null,
    @SerialName("views_ads_times_10") val viewsAdsTimes10: Int? = null,
    @SerialName("views_ads_times_5") val viewsAdsTimes5: String? = null,
    @SerialName("views_ads_times_11_plus") val viewsAdsTimes11Plus: Int? = null,
)
