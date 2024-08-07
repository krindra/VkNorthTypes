package ru.krindra.vkkt.objects.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param invite Who can invite users to chat
 * @param changeInfo Who can change chat info
 * @param changePin Who can change pinned message
 * @param useMassMentions Who can use mass mentions
 * @param seeInviteLink Who can see invite link
 * @param call Who can make calls
 * @param changeAdmins Who can change admins
 */
@Serializable
data class MessagesChatSettingsPermissions (
    @SerialName("call") val call: String? = null,
    @SerialName("invite") val invite: String? = null,
    @SerialName("change_pin") val changePin: String? = null,
    @SerialName("change_info") val changeInfo: String? = null,
    @SerialName("change_admins") val changeAdmins: String? = null,
    @SerialName("see_invite_link") val seeInviteLink: String? = null,
    @SerialName("use_mass_mentions") val useMassMentions: String? = null,
)
