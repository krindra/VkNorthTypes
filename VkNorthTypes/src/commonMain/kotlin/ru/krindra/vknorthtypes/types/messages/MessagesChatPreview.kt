package ru.krindra.vknorthtypes.types.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseLinkButton

/**
 *
 * @param adminId 
 * @param joined 
 * @param localId 
 * @param members 
 * @param membersCount 
 * @param title 
 * @param isMember 
 * @param photo 
 * @param isDon 
 * @param isNft 
 * @param isGroupChannel 
 * @param button 
 */
@Serializable
data class MessagesChatPreview (
    @SerialName("title") val title: String? = null,
    @SerialName("is_don") val isDon: Boolean? = null,
    @SerialName("is_nft") val isNft: Boolean? = null,
    @SerialName("admin_id") val adminId: Long? = null,
    @SerialName("joined") val joined: Boolean? = null,
    @SerialName("local_id") val localId: Long? = null,
    @SerialName("members") val members: List<Int>? = null,
    @SerialName("is_member") val isMember: Boolean? = null,
    @SerialName("button") val button: BaseLinkButton? = null,
    @SerialName("members_count") val membersCount: Int? = null,
    @SerialName("photo") val photo: MessagesChatSettingsPhoto? = null,
    @SerialName("is_group_channel") val isGroupChannel: Boolean? = null,
)
