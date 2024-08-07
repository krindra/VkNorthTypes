package ru.krindra.vkkt.objects.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param deactivated Returns if a profile is deleted or blocked
 * @param firstName User first name
 * @param hidden Returns if a profile is hidden.
 * @param id User ID
 * @param lastName User last name
 * @param canAccessClosed 
 * @param isClosed 
 */
@Serializable
data class UsersUserMin (
    @SerialName("id") val id: Int,
    @SerialName("hidden") val hidden: Int? = null,
    @SerialName("last_name") val lastName: String? = null,
    @SerialName("is_closed") val isClosed: Boolean? = null,
    @SerialName("first_name") val firstName: String? = null,
    @SerialName("deactivated") val deactivated: String? = null,
    @SerialName("can_access_closed") val canAccessClosed: Boolean? = null,
)
