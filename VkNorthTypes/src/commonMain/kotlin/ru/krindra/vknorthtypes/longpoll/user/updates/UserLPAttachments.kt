package ru.krindra.vknorthtypes.longpoll.user.updates

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import ru.krindra.vknorthtypes.JsonSingleton
import ru.krindra.vknorthtypes.longpoll.user.enums.AttachmentType


data class UserLPAttachments(
    val fwd: String? = null,
    val reply: Reply? = null,
    val attachments: List<Attachment> = emptyList()
) {
    data class Attachment(
        val type: AttachmentType,
        val attach: String,
    ) {
        constructor(type: String, attach: String)
                : this(AttachmentType.fromString(type), attach)
    }

    @Serializable
    data class Reply(
        @SerialName("conversation_message_id") val conversationMessageId: Int? = null,
    )

    companion object {
        fun fromJsonObject(rawAttachment: JsonObject?): UserLPAttachments {
            if (rawAttachment == null)
                return UserLPAttachments()
            val fwd = rawAttachment["fwd"]
                ?.jsonPrimitive?.contentOrNull
            val rawReply = rawAttachment["reply"]
            val reply: Reply? = rawReply?.let { JsonSingleton.json.decodeFromJsonElement(it) }
            val attachments = mutableListOf<Attachment>()
            for (i in 1..10) {
                val key = "attach$i"
                val rawType = rawAttachment[key + "_type"]?.jsonPrimitive?.content
                if (rawType != null) {
                    val attach: String = rawAttachment[key]!!.jsonPrimitive.content
                    attachments.add(Attachment(rawType, attach))
                }
            }
            return UserLPAttachments(fwd, reply, attachments)
        }
    }
}
