package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseBoolInt


@Serializable
data class GroupsGetSettingsResponse (
    val response: GroupsGetSettingsRawResponse
) {
    /**
     *
     * @param access Community access settings
     * @param address Community's page domain
     * @param audio Audio settings
     * @param articles Articles settings
     * @param recognizePhoto Photo suggests setting
     * @param cityId City id of group
     * @param cityName City name of group
     * @param contacts 
     * @param links 
     * @param sectionsList 
     * @param mainSection 
     * @param secondarySection 
     * @param ageLimits 
     * @param countryId Country id of group
     * @param countryName Country name of group
     * @param description Community description
     * @param docs Docs settings
     * @param events 
     * @param addresses 
     * @param botsCapabilities By enabling bot abilities, you can send users messages with a customized keyboard attached as well as use other promotional abilities
     * @param botsStartButton If this setting is enabled, users will see a Start button when they start a chat with your community for the first time
     * @param botsAddToChat If this setting is enabled then users can add your community to a chat
     * @param obsceneFilter Information whether the obscene filter is enabled
     * @param obsceneStopwords Information whether the stop words filter is enabled
     * @param obsceneWords The list of stop words
     * @param eventGroupId 
     * @param photos Photos settings
     * @param publicCategory Information about the group category
     * @param publicCategoryList 
     * @param publicDate 
     * @param publicDateLabel 
     * @param publicSubcategory Information about the group subcategory
     * @param rss URL of the RSS feed
     * @param startDate Start date
     * @param finishDate Finish date in Unix-time format
     * @param subject Community subject ID
     * @param subjectList 
     * @param suggestedPrivacy 
     * @param title Community title
     * @param topics Topics settings
     * @param twitter 
     * @param video Video settings
     * @param wall Wall settings
     * @param website Community website
     * @param phone Community phone
     * @param email Community email
     * @param wiki Wiki settings
     */
    @Serializable
    data class GroupsGetSettingsRawResponse (
        @SerialName("access") val access: GroupsGroupAccess? = null,
        @SerialName("address") val address: String? = null,
        @SerialName("audio") val audio: GroupsGroupAudio,
        @SerialName("articles") val articles: Int,
        @SerialName("recognize_photo") val recognizePhoto: Int? = null,
        @SerialName("city_id") val cityId: Long,
        @SerialName("city_name") val cityName: String,
        @SerialName("contacts") val contacts: BaseBoolInt? = null,
        @SerialName("links") val links: BaseBoolInt? = null,
        @SerialName("sections_list") val sectionsList: List<GroupsSectionsListItem>? = null,
        @SerialName("main_section") val mainSection: GroupsGroupFullSection? = null,
        @SerialName("secondary_section") val secondarySection: GroupsGroupFullSection? = null,
        @SerialName("age_limits") val ageLimits: GroupsGroupAgeLimits? = null,
        @SerialName("country_id") val countryId: Long,
        @SerialName("country_name") val countryName: String,
        @SerialName("description") val description: String,
        @SerialName("docs") val docs: GroupsGroupDocs,
        @SerialName("events") val events: BaseBoolInt? = null,
        @SerialName("addresses") val addresses: Boolean? = null,
        @SerialName("bots_capabilities") val botsCapabilities: BaseBoolInt? = null,
        @SerialName("bots_start_button") val botsStartButton: BaseBoolInt? = null,
        @SerialName("bots_add_to_chat") val botsAddToChat: BaseBoolInt? = null,
        @SerialName("obscene_filter") val obsceneFilter: BaseBoolInt,
        @SerialName("obscene_stopwords") val obsceneStopwords: BaseBoolInt,
        @SerialName("obscene_words") val obsceneWords: List<String>,
        @SerialName("event_group_id") val eventGroupId: Long? = null,
        @SerialName("photos") val photos: GroupsGroupPhotos,
        @SerialName("public_category") val publicCategory: Int? = null,
        @SerialName("public_category_list") val publicCategoryList: List<GroupsGroupPublicCategoryList>? = null,
        @SerialName("public_date") val publicDate: String? = null,
        @SerialName("public_date_label") val publicDateLabel: String? = null,
        @SerialName("public_subcategory") val publicSubcategory: Int? = null,
        @SerialName("rss") val rss: String? = null,
        @SerialName("start_date") val startDate: Int? = null,
        @SerialName("finish_date") val finishDate: Int? = null,
        @SerialName("subject") val subject: Int? = null,
        @SerialName("subject_list") val subjectList: List<GroupsSubjectItem>? = null,
        @SerialName("suggested_privacy") val suggestedPrivacy: GroupsGroupSuggestedPrivacy? = null,
        @SerialName("title") val title: String,
        @SerialName("topics") val topics: GroupsGroupTopics,
        @SerialName("twitter") val twitter: GroupsSettingsTwitter? = null,
        @SerialName("video") val video: GroupsGroupVideo,
        @SerialName("wall") val wall: GroupsGroupWall,
        @SerialName("website") val website: String? = null,
        @SerialName("phone") val phone: String? = null,
        @SerialName("email") val email: String? = null,
        @SerialName("wiki") val wiki: GroupsGroupWiki,
    )
}

