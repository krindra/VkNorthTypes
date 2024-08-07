package ru.krindra.vkkt.objects.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseLink
import ru.krindra.vkkt.objects.users.UsersUserMin
import ru.krindra.vkkt.objects.base.BaseBoolInt
import ru.krindra.vkkt.objects.groups.GroupsGroup
import ru.krindra.vkkt.objects.apps.AppsApp

/**
 *
 * @param app 
 * @param description Object description
 * @param global_ Information whether the object has been found globally
 * @param group 
 * @param profile 
 * @param section 
 * @param type 
 * @param link 
 */
@Serializable
data class SearchHint (
    @SerialName("app") val app: AppsApp? = null,
    @SerialName("type") val type: SearchHintType,
    @SerialName("link") val link: BaseLink? = null,
    @SerialName("description") val description: String,
    @SerialName("group") val group: GroupsGroup? = null,
    @SerialName("global_") val global_: BaseBoolInt? = null,
    @SerialName("profile") val profile: UsersUserMin? = null,
    @SerialName("section") val section: SearchHintSection? = null,
)
