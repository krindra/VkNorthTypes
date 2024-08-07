package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseBoolInt

/**
 *
 * @param adFormat Ad format
 * @param adPlatform Ad platform
 * @param allLimit Total limit
 * @param approved 
 * @param campaignId Campaign ID
 * @param category1Id Category ID
 * @param category2Id Additional category ID
 * @param costType 
 * @param cpc Cost of a click, kopecks
 * @param cpm Cost of 1000 impressions, kopecks
 * @param cpa Cost of an action, kopecks
 * @param ocpm Cost of 1000 impressions optimized, kopecks
 * @param autobidding Autobidding
 * @param autobiddingMaxCost Max cost of target actions for autobidding, kopecks
 * @param disclaimerMedical Information whether disclaimer is enabled
 * @param disclaimerSpecialist Information whether disclaimer is enabled
 * @param disclaimerSupplements Information whether disclaimer is enabled
 * @param id Ad ID
 * @param impressionsLimit Impressions limit
 * @param impressionsLimitPeriod Impressions limit period
 * @param impressionsLimited Information whether impressions are limited
 * @param name Ad title
 * @param status 
 * @param video Information whether the ad is a video
 * @param dayLimit Day limit
 * @param goalType Goal type
 * @param userGoalType User goal type
 * @param ageRestriction Age restriction
 * @param conversionPixelId Conversion pixel id
 * @param conversionEventId Conversion event id
 * @param createTime Create time
 * @param updateTime Update time
 * @param startTime Start time
 * @param stopTime Stop time
 * @param publisherPlatformsAuto Publisher platform auto
 * @param publisherPlatforms Publisher platforms
 * @param linkUrl Link url
 * @param linkOwnerId Link owner id
 * @param linkId Link id
 * @param hasCampaignBudgetOptimization Has campaign budget optimization
 * @param eventsRetargetingGroups Events retargeting groups
 * @param weeklyScheduleHours Weekly schedule hours
 * @param weeklyScheduleUseHolidays Weekly schedule use holidays
 * @param adPlatformNoAdNetwork Ad platform no ad network
 * @param adPlatformNoWall Ad platform no wall
 * @param disclaimerFinance Disclaimer finance
 * @param disclaimerFinanceName Disclaimer finance name
 * @param disclaimerFinanceLicenseNo Disclaimer finance license no
 * @param isPromo is promo
 * @param suggestedCriteria Suggested criteria
 */
@Serializable
data class AdsAd (
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("ad_format") val adFormat: Int,
    @SerialName("cpa") val cpa: String? = null,
    @SerialName("cpc") val cpc: String? = null,
    @SerialName("cpm") val cpm: String? = null,
    @SerialName("ocpm") val ocpm: String? = null,
    @SerialName("all_limit") val allLimit: String,
    @SerialName("status") val status: AdsAdStatus,
    @SerialName("campaign_id") val campaignId: Int,
    @SerialName("link_id") val linkId: Int? = null,
    @SerialName("ad_platform") val adPlatform: String,
    @SerialName("goal_type") val goalType: Int? = null,
    @SerialName("stop_time") val stopTime: Int? = null,
    @SerialName("approved") val approved: AdsAdApproved,
    @SerialName("link_url") val linkUrl: String? = null,
    @SerialName("video") val video: BaseBoolInt? = null,
    @SerialName("cost_type") val costType: AdsAdCostType,
    @SerialName("is_promo") val isPromo: Boolean? = null,
    @SerialName("start_time") val startTime: Int? = null,
    @SerialName("day_limit") val dayLimit: String? = null,
    @SerialName("create_time") val createTime: Int? = null,
    @SerialName("update_time") val updateTime: Int? = null,
    @SerialName("category1_id") val category1Id: Int? = null,
    @SerialName("category2_id") val category2Id: Int? = null,
    @SerialName("link_owner_id") val linkOwnerId: Int? = null,
    @SerialName("user_goal_type") val userGoalType: Int? = null,
    @SerialName("age_restriction") val ageRestriction: Int? = null,
    @SerialName("autobidding") val autobidding: BaseBoolInt? = null,
    @SerialName("impressions_limit") val impressionsLimit: Int? = null,
    @SerialName("ad_platform_no_wall") val adPlatformNoWall: Int? = null,
    @SerialName("disclaimer_finance") val disclaimerFinance: Int? = null,
    @SerialName("suggested_criteria") val suggestedCriteria: Int? = null,
    @SerialName("conversion_event_id") val conversionEventId: Int? = null,
    @SerialName("conversion_pixel_id") val conversionPixelId: Int? = null,
    @SerialName("publisher_platforms") val publisherPlatforms: String? = null,
    @SerialName("autobidding_max_cost") val autobiddingMaxCost: String? = null,
    @SerialName("disclaimer_medical") val disclaimerMedical: BaseBoolInt? = null,
    @SerialName("impressions_limited") val impressionsLimited: BaseBoolInt? = null,
    @SerialName("ad_platform_no_ad_network") val adPlatformNoAdNetwork: Int? = null,
    @SerialName("impressions_limit_period") val impressionsLimitPeriod: Int? = null,
    @SerialName("disclaimer_finance_name") val disclaimerFinanceName: String? = null,
    @SerialName("disclaimer_specialist") val disclaimerSpecialist: BaseBoolInt? = null,
    @SerialName("weekly_schedule_hours") val weeklyScheduleHours: List<String>? = null,
    @SerialName("disclaimer_supplements") val disclaimerSupplements: BaseBoolInt? = null,
    @SerialName("weekly_schedule_use_holidays") val weeklyScheduleUseHolidays: Int? = null,
    @SerialName("publisher_platforms_auto") val publisherPlatformsAuto: BaseBoolInt? = null,
    @SerialName("disclaimer_finance_license_no") val disclaimerFinanceLicenseNo: String? = null,
    @SerialName("has_campaign_budget_optimization") val hasCampaignBudgetOptimization: Boolean? = null,
    @SerialName("events_retargeting_groups") val eventsRetargetingGroups: List<AdsEventsRetargetingGroup>? = null,
)
