package ru.krindra.vkkt.objects.wall

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param comments Comments number
 * @param date Date when the note has been created in Unixtime
 * @param id Note ID
 * @param ownerId Note owner's ID
 * @param readComments Read comments number
 * @param title Note title
 * @param text Note text
 * @param privacyView 
 * @param privacyComment 
 * @param canComment 
 * @param textWiki Note wiki text
 * @param viewUrl URL of the page with note preview
 */
@Serializable
data class WallAttachedNote (
    @SerialName("id") val id: Int,
    @SerialName("date") val date: Int,
    @SerialName("title") val title: String,
    @SerialName("owner_id") val ownerId: Int,
    @SerialName("comments") val comments: Int,
    @SerialName("view_url") val viewUrl: String,
    @SerialName("text") val text: String? = null,
    @SerialName("read_comments") val readComments: Int,
    @SerialName("text_wiki") val textWiki: String? = null,
    @SerialName("can_comment") val canComment: Int? = null,
    @SerialName("privacy_view") val privacyView: List<String>? = null,
    @SerialName("privacy_comment") val privacyComment: List<String>? = null,
)
