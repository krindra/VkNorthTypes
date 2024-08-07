package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Action type
 * 
 */
@Serializable
enum class BaseLinkButtonActionType(val value: String){
    @SerialName("open_url") OPEN_URL("open_url"),
    @SerialName("market_clear_recent_queries") MARKET_CLEAR_RECENT_QUERIES("market_clear_recent_queries"),
    @SerialName("close_web_app") CLOSE_WEB_APP("close_web_app"),
    @SerialName("open_search_tab") OPEN_SEARCH_TAB("open_search_tab"),
    @SerialName("import_contacts") IMPORT_CONTACTS("import_contacts"),
    @SerialName("add_friends") ADD_FRIENDS("add_friends"),
    @SerialName("onboarding") ONBOARDING("onboarding"),
}
