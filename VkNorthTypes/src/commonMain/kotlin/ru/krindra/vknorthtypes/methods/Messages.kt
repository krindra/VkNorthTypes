package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.messages.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.users.UsersFields
import ru.krindra.vknorthtypes.types.base.BaseUserGroupFields
import ru.krindra.vknorthtypes.types.base.BaseBoolResponse
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Messages(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Adds a new user to a chat.
     * 
     * @param chatId Chat ID.
     * @param userId ID of the user to be added to the chat.
     * @param visibleMessagesCount 
     */
    suspend fun addChatUser(chatId: Long, userId: Long? = null, visibleMessagesCount: Int? = null): BaseOkResponse {
        val response = method("addChatUser", mapOf("chat_id" to chatId, "user_id" to userId, "visible_messages_count" to visibleMessagesCount))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Adds new users to a chat.
     * 
     * @param chatId 
     * @param visibleMessagesCount 
     */
    suspend fun addChatUsers(chatId: Long? = null, visibleMessagesCount: Int? = null): MessagesAddChatUsersResponse {
        val response = method("addChatUsers", mapOf("chat_id" to chatId, "visible_messages_count" to visibleMessagesCount))
        return json.decodeFromString<MessagesAddChatUsersResponse>(response)
    }

    /**
     *
     * Allows sending messages from community to the current user.
     * 
     * @param groupId Group ID.
     * @param key 
     */
    suspend fun allowMessagesFromGroup(groupId: Long, key: String? = null): BaseOkResponse {
        val response = method("allowMessagesFromGroup", mapOf("group_id" to groupId, "key" to key))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Creates a chat with several participants.
     * 
     * @param userIds IDs of the users to be added to the chat.
     * @param title Chat title.
     * @param groupId 
     */
    suspend fun createChat(userIds: List<Int>? = null, title: String? = null, groupId: Long? = null): MessagesCreateChatWithPeerIdsResponse {
        val response = method("createChat", mapOf("user_ids" to userIds, "title" to title, "group_id" to groupId))
        return json.decodeFromString<MessagesCreateChatWithPeerIdsResponse>(response)
    }

    /**
     *
     * Deletes one or more messages.
     * 
     * @param messageIds Message IDs.
     * @param spam '1' - to mark message as spam.
     * @param groupId Group ID (for group messages with user access token).
     * @param deleteForAll '1' - delete message for for all.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param cmids Conversation message IDs.
     */
    suspend fun delete(messageIds: List<Int>? = null, spam: Boolean? = false, groupId: Long? = null, deleteForAll: Boolean? = false, peerId: Long? = null, cmids: List<Int>? = null): MessagesDeleteFullResponse {
        val response = method("delete", mapOf("message_ids" to messageIds, "spam" to spam, "group_id" to groupId, "delete_for_all" to deleteForAll, "peer_id" to peerId, "cmids" to cmids))
        return json.decodeFromString<MessagesDeleteFullResponse>(response)
    }

    /**
     *
     * Deletes a chat's cover picture.
     * 
     * @param chatId Chat ID.
     * @param groupId 
     */
    suspend fun deleteChatPhoto(chatId: Long, groupId: Long? = null): MessagesDeleteChatPhotoResponse {
        val response = method("deleteChatPhoto", mapOf("chat_id" to chatId, "group_id" to groupId))
        return json.decodeFromString<MessagesDeleteChatPhotoResponse>(response)
    }

    /**
     *
     * Deletes all private messages in a conversation.
     * 
     * @param userId User ID. To clear a chat history use 'chat_id'.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param groupId Group ID (for group messages with user access token).
     */
    suspend fun deleteConversation(userId: Long? = null, peerId: Long? = null, groupId: Long? = null): MessagesDeleteConversationResponse {
        val response = method("deleteConversation", mapOf("user_id" to userId, "peer_id" to peerId, "group_id" to groupId))
        return json.decodeFromString<MessagesDeleteConversationResponse>(response)
    }

    /**
     *
     * Delete message reaction
     * 
     * @param peerId 
     * @param cmid 
     */
    suspend fun deleteReaction(peerId: Long, cmid: Long): BaseBoolResponse {
        val response = method("deleteReaction", mapOf("peer_id" to peerId, "cmid" to cmid))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Denies sending message from community to the current user.
     * 
     * @param groupId Group ID.
     */
    suspend fun denyMessagesFromGroup(groupId: Long): BaseOkResponse {
        val response = method("denyMessagesFromGroup", mapOf("group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits the message.
     * 
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param message (Required if 'attachments' is not set.) Text of the message.
     * @param lat Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param attachment (Required if 'message' is not set.) List of objects attached to the message, separated by commas, in the following format: "<owner_id>_<media_id>", '' - Type of media attachment: 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'wall' - wall post, '<owner_id>' - ID of the media attachment owner. '<media_id>' - media attachment ID. Example: "photo100172_166443618".
     * @param keepForwardMessages '1' - to keep forwarded, messages.
     * @param keepSnippets '1' - to keep attached snippets.
     * @param groupId Group ID (for group messages with user access token).
     * @param dontParseLinks 
     * @param disableMentions 
     * @param messageId 
     * @param cmid 
     * @param template 
     * @param keyboard 
     */
    suspend fun edit(peerId: Long, message: String? = null, lat: Double? = null, long: Double? = null, attachment: String? = null, keepForwardMessages: Boolean? = false, keepSnippets: Boolean? = false, groupId: Long? = null, dontParseLinks: Boolean? = false, disableMentions: Boolean? = false, messageId: Long? = null, cmid: Long? = null, template: String? = null, keyboard: String? = null): BaseBoolResponse {
        val response = method("edit", mapOf("peer_id" to peerId, "message" to message, "lat" to lat, "long" to long, "attachment" to attachment, "keep_forward_messages" to keepForwardMessages, "keep_snippets" to keepSnippets, "group_id" to groupId, "dont_parse_links" to dontParseLinks, "disable_mentions" to disableMentions, "message_id" to messageId, "cmid" to cmid, "template" to template, "keyboard" to keyboard))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Edits the title of a chat.
     * 
     * @param chatId Chat ID.
     * @param title New title of the chat.
     */
    suspend fun editChat(chatId: Long, title: String? = null): BaseOkResponse {
        val response = method("editChat", mapOf("chat_id" to chatId, "title" to title))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns messages by their IDs within the conversation.
     * 
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param conversationMessageIds Conversation message IDs.
     * @param extended Information whether the response should be extended.
     * @param fields Profile fields to return.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun getByConversationMessageId(peerId: Long, conversationMessageIds: List<Int>, extended: Boolean? = false, fields: List<UsersFields>? = null, groupId: Long? = null): GetbyconversationmessageidResponse {
        val response = method("getByConversationMessageId", mapOf("peer_id" to peerId, "conversation_message_ids" to conversationMessageIds, "extended" to extended, "fields" to fields, "group_id" to groupId))
        return GetbyconversationmessageidResponse(response, json)
    }
    class GetbyconversationmessageidResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesGetByConversationMessageIdResponse.serializer(), MessagesGetByConversationMessageIdExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesGetByConversationMessageIdResponse(): MessagesGetByConversationMessageIdResponse?{
            return if (response is MessagesGetByConversationMessageIdResponse) response else null
        }
        fun MessagesGetByConversationMessageIdExtendedResponse(): MessagesGetByConversationMessageIdExtendedResponse?{
            return if (response is MessagesGetByConversationMessageIdExtendedResponse) response else null
        }
    }

    /**
     *
     * Returns messages by their IDs.
     * 
     * @param messageIds Message IDs.
     * @param previewLength Number of characters after which to truncate a previewed message. To preview the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated by words.".
     * @param extended Information whether the response should be extended.
     * @param fields Profile fields to return.
     * @param groupId Group ID (for group messages with group access token).
     * @param cmids 
     * @param peerId 
     */
    suspend fun getById(messageIds: List<Int>? = null, previewLength: Int? = 0, extended: Boolean? = false, fields: List<UsersFields>? = null, groupId: Long? = null, cmids: List<Int>? = null, peerId: Long? = null): GetbyidResponse {
        val response = method("getById", mapOf("message_ids" to messageIds, "preview_length" to previewLength, "extended" to extended, "fields" to fields, "group_id" to groupId, "cmids" to cmids, "peer_id" to peerId))
        return GetbyidResponse(response, json)
    }
    class GetbyidResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesGetByIdResponse.serializer(), MessagesGetByIdExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesGetByIdResponse(): MessagesGetByIdResponse?{
            return if (response is MessagesGetByIdResponse) response else null
        }
        fun MessagesGetByIdExtendedResponse(): MessagesGetByIdExtendedResponse?{
            return if (response is MessagesGetByIdExtendedResponse) response else null
        }
    }

    /**
     *
     * Returns information about a chat.
     * 
     * @param chatId Chat ID.
     * @param chatIds Chat IDs.
     * @param fields Profile fields to return.
     * @param nameCase Case for declension of user name and surname: 'nom' - nominative (default), 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' - prepositional.
     */
    suspend fun getChat(chatId: Long? = null, chatIds: List<Int>? = null, fields: List<UsersFields>? = null, nameCase: String? = null): GetchatResponse {
        val response = method("getChat", mapOf("chat_id" to chatId, "chat_ids" to chatIds, "fields" to fields, "name_case" to nameCase))
        return GetchatResponse(response, json)
    }
    class GetchatResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesGetChatChatIdsFieldsResponse.serializer(), MessagesGetChatChatIdsResponse.serializer(), MessagesGetChatResponse.serializer(), MessagesGetChatFieldsResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesGetChatChatIdsFieldsResponse(): MessagesGetChatChatIdsFieldsResponse?{
            return if (response is MessagesGetChatChatIdsFieldsResponse) response else null
        }
        fun MessagesGetChatChatIdsResponse(): MessagesGetChatChatIdsResponse?{
            return if (response is MessagesGetChatChatIdsResponse) response else null
        }
        fun MessagesGetChatResponse(): MessagesGetChatResponse?{
            return if (response is MessagesGetChatResponse) response else null
        }
        fun MessagesGetChatFieldsResponse(): MessagesGetChatFieldsResponse?{
            return if (response is MessagesGetChatFieldsResponse) response else null
        }
    }

    /**
     *
     * @param peerId 
     * @param link Invitation link.
     * @param fields Profile fields to return.
     */
    suspend fun getChatPreview(peerId: Long? = null, link: String? = null, fields: List<UsersFields>? = null): MessagesGetChatPreviewResponse {
        val response = method("getChatPreview", mapOf("peer_id" to peerId, "link" to link, "fields" to fields))
        return json.decodeFromString<MessagesGetChatPreviewResponse>(response)
    }

    /**
     *
     * Returns a list of IDs of users participating in a chat.
     * 
     * @param peerId Peer ID.
     * @param offset 
     * @param count 
     * @param extended Extended flag.
     * @param fields Profile fields to return.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun getConversationMembers(peerId: Long, offset: Int? = 0, count: Int? = 20, extended: Boolean? = false, fields: List<UsersFields>? = null, groupId: Long? = null): MessagesGetConversationMembersResponse {
        val response = method("getConversationMembers", mapOf("peer_id" to peerId, "offset" to offset, "count" to count, "extended" to extended, "fields" to fields, "group_id" to groupId))
        return json.decodeFromString<MessagesGetConversationMembersResponse>(response)
    }

    /**
     *
     * Returns a list of the current user's conversations.
     * 
     * @param offset Offset needed to return a specific subset of conversations.
     * @param count Number of conversations to return.
     * @param filter Filter to apply: 'all' - all conversations, 'unread' - conversations with unread messages, 'important' - conversations, marked as important (only for community messages), 'unanswered' - conversations, marked as unanswered (only for community messages).
     * @param extended '1' - return extra information about users and communities.
     * @param startMessageId ID of the message from what to return dialogs.
     * @param fields Profile and communities fields to return.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun getConversations(offset: Int? = 0, count: Int? = 20, filter: String? = "all", extended: Boolean? = false, startMessageId: Long? = null, fields: List<BaseUserGroupFields>? = null, groupId: Long? = null): MessagesGetConversationsResponse {
        val response = method("getConversations", mapOf("offset" to offset, "count" to count, "filter" to filter, "extended" to extended, "start_message_id" to startMessageId, "fields" to fields, "group_id" to groupId))
        return json.decodeFromString<MessagesGetConversationsResponse>(response)
    }

    /**
     *
     * Returns conversations by their IDs
     * 
     * @param peerIds Destination IDs. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param extended Return extended properties.
     * @param fields Profile and communities fields to return.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun getConversationsById(peerIds: List<Int>, extended: Boolean? = false, fields: List<BaseUserGroupFields>? = null, groupId: Long? = null): GetconversationsbyidResponse {
        val response = method("getConversationsById", mapOf("peer_ids" to peerIds, "extended" to extended, "fields" to fields, "group_id" to groupId))
        return GetconversationsbyidResponse(response, json)
    }
    class GetconversationsbyidResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesGetConversationsByIdExtendedResponse.serializer(), MessagesGetConversationsByIdResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesGetConversationsByIdExtendedResponse(): MessagesGetConversationsByIdExtendedResponse?{
            return if (response is MessagesGetConversationsByIdExtendedResponse) response else null
        }
        fun MessagesGetConversationsByIdResponse(): MessagesGetConversationsByIdResponse?{
            return if (response is MessagesGetConversationsByIdResponse) response else null
        }
    }

    /**
     *
     * Returns message history for the specified user or group chat.
     * 
     * @param offset Offset needed to return a specific subset of messages.
     * @param count Number of messages to return.
     * @param userId ID of the user whose message history you want to return.
     * @param peerId 
     * @param startMessageId Starting message ID from which to return history.
     * @param rev Sort order: '1' - return messages in chronological order. '0' - return messages in reverse chronological order.
     * @param extended Information whether the response should be extended.
     * @param fields Profile fields to return.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun getHistory(offset: Int? = null, count: Int? = 20, userId: Long? = null, peerId: Long? = null, startMessageId: Long? = null, rev: Int? = null, extended: Boolean? = false, fields: List<UsersFields>? = null, groupId: Long? = null): GethistoryResponse {
        val response = method("getHistory", mapOf("offset" to offset, "count" to count, "user_id" to userId, "peer_id" to peerId, "start_message_id" to startMessageId, "rev" to rev, "extended" to extended, "fields" to fields, "group_id" to groupId))
        return GethistoryResponse(response, json)
    }
    class GethistoryResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesGetHistoryExtendedResponse.serializer(), MessagesGetHistoryResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesGetHistoryExtendedResponse(): MessagesGetHistoryExtendedResponse?{
            return if (response is MessagesGetHistoryExtendedResponse) response else null
        }
        fun MessagesGetHistoryResponse(): MessagesGetHistoryResponse?{
            return if (response is MessagesGetHistoryResponse) response else null
        }
    }

    /**
     *
     * Returns media files from the dialog or group chat.
     * 
     * @param attachmentTypes 
     * @param groupId Group ID (for group messages with group access token).
     * @param peerId Peer ID. ", For group chat: '2000000000 + chat ID' , , For community: '-community ID'".
     * @param cmid 
     * @param attachmentPosition 
     * @param offset 
     * @param count Number of objects to return.
     * @param extended 
     * @param fields Additional profile [vk.com/dev/fields|fields] to return. .
     * @param maxForwardsLevel 
     * @param mediaType Type of media files to return: *'photo',, *'video',, *'audio',, *'doc',, *'link'.,*'market'.,*'wall'.,*'share'.
     * @param startFrom Message ID to start return results from.
     * @param preserveOrder 
     * @param photoSizes '1' - to return photo sizes in a.
     */
    suspend fun getHistoryAttachments(attachmentTypes: List<String>? = null, groupId: Long? = null, peerId: Long? = null, cmid: Long? = null, attachmentPosition: Int? = null, offset: Int? = null, count: Int? = 30, extended: Boolean? = false, fields: List<UsersFields>? = null, maxForwardsLevel: Int? = 45, mediaType: String? = "photo", startFrom: String? = null, preserveOrder: Boolean? = false, photoSizes: Boolean? = false): MessagesGetHistoryAttachmentsResponse {
        val response = method("getHistoryAttachments", mapOf("attachment_types" to attachmentTypes, "group_id" to groupId, "peer_id" to peerId, "cmid" to cmid, "attachment_position" to attachmentPosition, "offset" to offset, "count" to count, "extended" to extended, "fields" to fields, "max_forwards_level" to maxForwardsLevel, "media_type" to mediaType, "start_from" to startFrom, "preserve_order" to preserveOrder, "photo_sizes" to photoSizes))
        return json.decodeFromString<MessagesGetHistoryAttachmentsResponse>(response)
    }

    /**
     *
     * Returns a list of user's important messages.
     * 
     * @param count Amount of needed important messages.
     * @param offset 
     * @param startMessageId 
     * @param previewLength Maximum length of messages body.
     * @param fields Actors fields to return.
     * @param extended Return extended properties.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun getImportantMessages(count: Int? = 20, offset: Int? = null, startMessageId: Long? = null, previewLength: Int? = null, fields: List<BaseUserGroupFields>? = null, extended: Boolean? = false, groupId: Long? = null): GetimportantmessagesResponse {
        val response = method("getImportantMessages", mapOf("count" to count, "offset" to offset, "start_message_id" to startMessageId, "preview_length" to previewLength, "fields" to fields, "extended" to extended, "group_id" to groupId))
        return GetimportantmessagesResponse(response, json)
    }
    class GetimportantmessagesResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesGetImportantMessagesResponse.serializer(), MessagesGetImportantMessagesExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesGetImportantMessagesResponse(): MessagesGetImportantMessagesResponse?{
            return if (response is MessagesGetImportantMessagesResponse) response else null
        }
        fun MessagesGetImportantMessagesExtendedResponse(): MessagesGetImportantMessagesExtendedResponse?{
            return if (response is MessagesGetImportantMessagesExtendedResponse) response else null
        }
    }

    /**
     *
     * @param intent 
     * @param subscribeId 
     * @param offset 
     * @param count 
     * @param extended 
     * @param nameCase 
     * @param fields 
     */
    suspend fun getIntentUsers(intent: String, subscribeId: Long? = null, offset: Int? = 0, count: Int? = 20, extended: Boolean? = false, nameCase: List<String>? = null, fields: List<String>? = null): MessagesGetIntentUsersResponse {
        val response = method("getIntentUsers", mapOf("intent" to intent, "subscribe_id" to subscribeId, "offset" to offset, "count" to count, "extended" to extended, "name_case" to nameCase, "fields" to fields))
        return json.decodeFromString<MessagesGetIntentUsersResponse>(response)
    }

    /**
     *
     * @param peerId Destination ID.
     * @param reset 1 - to generate new link (revoke previous), 0 - to return previous link.
     * @param groupId Group ID.
     */
    suspend fun getInviteLink(peerId: Long, reset: Boolean? = false, groupId: Long? = null): MessagesGetInviteLinkResponse {
        val response = method("getInviteLink", mapOf("peer_id" to peerId, "reset" to reset, "group_id" to groupId))
        return json.decodeFromString<MessagesGetInviteLinkResponse>(response)
    }

    /**
     *
     * Returns a user's current status and date of last activity.
     * 
     * @param userId User ID.
     */
    suspend fun getLastActivity(userId: Long): MessagesGetLastActivityResponse {
        val response = method("getLastActivity", mapOf("user_id" to userId))
        return json.decodeFromString<MessagesGetLastActivityResponse>(response)
    }

    /**
     *
     * Returns updates in user's private messages.
     * 
     * @param ts Last value of the 'ts' parameter returned from the Long Poll server or by using [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param pts Last value of 'pts' parameter returned from the Long Poll server or by using [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param previewLength Number of characters after which to truncate a previewed message. To preview the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated by words.".
     * @param onlines '1' - to return history with online users only.
     * @param fields Additional profile [vk.com/dev/fields|fields] to return.
     * @param eventsLimit Maximum number of events to return.
     * @param msgsLimit Maximum number of messages to return.
     * @param maxMsgId Maximum ID of the message among existing ones in the local copy. Both messages received with API methods (for example, , ), and data received from a Long Poll server (events with code 4) are taken into account.
     * @param groupId Group ID (for group messages with user access token).
     * @param lpVersion 
     * @param lastN 
     * @param credentials 
     * @param extended 
     */
    suspend fun getLongPollHistory(ts: Int? = null, pts: Int? = null, previewLength: Int? = null, onlines: Boolean? = false, fields: List<UsersFields>? = null, eventsLimit: Int? = 1000, msgsLimit: Int? = 200, maxMsgId: Long? = null, groupId: Long? = null, lpVersion: Int? = null, lastN: Int? = 0, credentials: Boolean? = false, extended: Boolean? = false): MessagesGetLongPollHistoryResponse {
        val response = method("getLongPollHistory", mapOf("ts" to ts, "pts" to pts, "preview_length" to previewLength, "onlines" to onlines, "fields" to fields, "events_limit" to eventsLimit, "msgs_limit" to msgsLimit, "max_msg_id" to maxMsgId, "group_id" to groupId, "lp_version" to lpVersion, "last_n" to lastN, "credentials" to credentials, "extended" to extended))
        return json.decodeFromString<MessagesGetLongPollHistoryResponse>(response)
    }

    /**
     *
     * Returns data required for connection to a Long Poll server.
     * 
     * @param needPts '1' - to return the 'pts' field, needed for the [vk.com/dev/messages.getLongPollHistory|messages.getLongPollHistory] method.
     * @param groupId Group ID (for group messages with user access token).
     * @param lpVersion Long poll version.
     */
    suspend fun getLongPollServer(needPts: Boolean? = false, groupId: Long? = null, lpVersion: Int? = 0): MessagesGetLongPollServerResponse {
        val response = method("getLongPollServer", mapOf("need_pts" to needPts, "group_id" to groupId, "lp_version" to lpVersion))
        return json.decodeFromString<MessagesGetLongPollServerResponse>(response)
    }

    /**
     *
     * Get reaction counters for message
     * 
     * @param peerId 
     * @param cmids 
     */
    suspend fun getMessagesReactions(peerId: Long, cmids: List<Int>): MessagesGetMessagesReactionsResponse {
        val response = method("getMessagesReactions", mapOf("peer_id" to peerId, "cmids" to cmids))
        return json.decodeFromString<MessagesGetMessagesReactionsResponse>(response)
    }

    /**
     *
     * Get reacted users and counters for message
     * 
     * @param peerId 
     * @param cmid 
     * @param reactionId 
     */
    suspend fun getReactedPeers(peerId: Long, cmid: Long, reactionId: Long? = null): MessagesGetReactedPeersResponse {
        val response = method("getReactedPeers", mapOf("peer_id" to peerId, "cmid" to cmid, "reaction_id" to reactionId))
        return json.decodeFromString<MessagesGetReactedPeersResponse>(response)
    }

    /**
     *
     * Get assets to display message reactions
     * 
     * @param clientVersion 
     */
    suspend fun getReactionsAssets(clientVersion: Int? = null): MessagesGetReactionsAssetsResponse {
        val response = method("getReactionsAssets", mapOf("client_version" to clientVersion))
        return json.decodeFromString<MessagesGetReactionsAssetsResponse>(response)
    }

    /**
     *
     * Returns information whether sending messages from the community to current user is allowed.
     * 
     * @param groupId Group ID.
     * @param userId User ID.
     */
    suspend fun isMessagesFromGroupAllowed(groupId: Long, userId: Long): MessagesIsMessagesFromGroupAllowedResponse {
        val response = method("isMessagesFromGroupAllowed", mapOf("group_id" to groupId, "user_id" to userId))
        return json.decodeFromString<MessagesIsMessagesFromGroupAllowedResponse>(response)
    }

    /**
     *
     * @param link Invitation link.
     */
    suspend fun joinChatByInviteLink(link: String): MessagesJoinChatByInviteLinkResponse {
        val response = method("joinChatByInviteLink", mapOf("link" to link))
        return json.decodeFromString<MessagesJoinChatByInviteLinkResponse>(response)
    }

    /**
     *
     * Marks and unmarks conversations as unanswered.
     * 
     * @param peerId ID of conversation to mark as important.
     * @param answered '1' - to mark as answered, '0' - to remove the mark.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun markAsAnsweredConversation(peerId: Long, answered: Boolean? = true, groupId: Long? = null): BaseOkResponse {
        val response = method("markAsAnsweredConversation", mapOf("peer_id" to peerId, "answered" to answered, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Marks and unmarks messages as important (starred).
     * 
     * @param messageIds IDs of messages to mark as important.
     * @param important '1' - to add a star (mark as important), '0' - to remove the star.
     */
    suspend fun markAsImportant(messageIds: List<Int>? = null, important: Int? = null): MessagesMarkAsImportantDeprecatedResponse {
        val response = method("markAsImportant", mapOf("message_ids" to messageIds, "important" to important))
        return json.decodeFromString<MessagesMarkAsImportantDeprecatedResponse>(response)
    }

    /**
     *
     * Marks and unmarks conversations as important.
     * 
     * @param peerId ID of conversation to mark as important.
     * @param important '1' - to add a star (mark as important), '0' - to remove the star.
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun markAsImportantConversation(peerId: Long, important: Boolean? = true, groupId: Long? = null): BaseOkResponse {
        val response = method("markAsImportantConversation", mapOf("peer_id" to peerId, "important" to important, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Marks messages as read.
     * 
     * @param messageIds IDs of messages to mark as read.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param startMessageId Message ID to start from.
     * @param groupId Group ID (for group messages with user access token).
     * @param markConversationAsRead 
     * @param upToCmid 
     */
    suspend fun markAsRead(messageIds: List<Int>? = listOf(), peerId: Long? = null, startMessageId: Long? = null, groupId: Long? = null, markConversationAsRead: Boolean? = false, upToCmid: Long? = null): BaseOkResponse {
        val response = method("markAsRead", mapOf("message_ids" to messageIds, "peer_id" to peerId, "start_message_id" to startMessageId, "group_id" to groupId, "mark_conversation_as_read" to markConversationAsRead, "up_to_cmid" to upToCmid))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Mark messages reactions as read
     * 
     * @param peerId 
     * @param cmids 
     */
    suspend fun markReactionsAsRead(peerId: Long, cmids: List<Int>? = null): BaseBoolResponse {
        val response = method("markReactionsAsRead", mapOf("peer_id" to peerId, "cmids" to cmids))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Pin a message.
     * 
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'Chat ID', e.g. '2000000001'. For community: '- Community ID', e.g. '-12345'. ".
     * @param messageId Message ID.
     * @param cmid Conversation message ID.
     */
    suspend fun pin(peerId: Long, messageId: Long? = null, cmid: Long? = null): MessagesPinResponse {
        val response = method("pin", mapOf("peer_id" to peerId, "message_id" to messageId, "cmid" to cmid))
        return json.decodeFromString<MessagesPinResponse>(response)
    }

    /**
     *
     * Allows the current user to leave a chat or, if the current user started the chat, allows the user to remove another user from the chat.
     * 
     * @param chatId Chat ID.
     * @param userId ID of the user to be removed from the chat.
     * @param memberId 
     */
    suspend fun removeChatUser(chatId: Long, userId: Long? = null, memberId: Long? = null): BaseOkResponse {
        val response = method("removeChatUser", mapOf("chat_id" to chatId, "user_id" to userId, "member_id" to memberId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Restores a deleted message.
     * 
     * @param messageId ID of a previously-deleted message to restore.
     * @param groupId Group ID (for group messages with user access token).
     * @param cmid 
     * @param peerId Destination ID.
     */
    suspend fun restore(messageId: Long? = null, groupId: Long? = null, cmid: Long? = null, peerId: Long? = null): BaseOkResponse {
        val response = method("restore", mapOf("message_id" to messageId, "group_id" to groupId, "cmid" to cmid, "peer_id" to peerId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns a list of the current user's private messages that match search criteria.
     * 
     * @param q Search query string.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param date Date to search message before in Unixtime.
     * @param previewLength Number of characters after which to truncate a previewed message. To preview the full message, specify '0'. "NOTE: Messages are not truncated by default. Messages are truncated by words.".
     * @param offset Offset needed to return a specific subset of messages.
     * @param count Number of messages to return.
     * @param extended 
     * @param fields 
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun search(q: String? = null, peerId: Long? = null, date: Int? = null, previewLength: Int? = 0, offset: Int? = 0, count: Int? = 20, extended: Boolean? = false, fields: List<String>? = null, groupId: Long? = null): SearchResponse {
        val response = method("search", mapOf("q" to q, "peer_id" to peerId, "date" to date, "preview_length" to previewLength, "offset" to offset, "count" to count, "extended" to extended, "fields" to fields, "group_id" to groupId))
        return SearchResponse(response, json)
    }
    class SearchResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesSearchExtendedResponse.serializer(), MessagesSearchResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesSearchExtendedResponse(): MessagesSearchExtendedResponse?{
            return if (response is MessagesSearchExtendedResponse) response else null
        }
        fun MessagesSearchResponse(): MessagesSearchResponse?{
            return if (response is MessagesSearchResponse) response else null
        }
    }

    /**
     *
     * Returns a list of the current user's conversations that match search criteria.
     * 
     * @param q Search query string.
     * @param count Maximum number of results.
     * @param extended '1' - return extra information about users and communities.
     * @param fields Profile fields to return.
     * @param groupId Group ID (for group messages with user access token).
     */
    suspend fun searchConversations(q: String? = null, count: Int? = 20, extended: Boolean? = false, fields: List<UsersFields>? = null, groupId: Long? = null): SearchconversationsResponse {
        val response = method("searchConversations", mapOf("q" to q, "count" to count, "extended" to extended, "fields" to fields, "group_id" to groupId))
        return SearchconversationsResponse(response, json)
    }
    class SearchconversationsResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesSearchConversationsResponse.serializer(), MessagesSearchConversationsExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesSearchConversationsResponse(): MessagesSearchConversationsResponse?{
            return if (response is MessagesSearchConversationsResponse) response else null
        }
        fun MessagesSearchConversationsExtendedResponse(): MessagesSearchConversationsExtendedResponse?{
            return if (response is MessagesSearchConversationsExtendedResponse) response else null
        }
    }

    /**
     *
     * Sends a message.
     * 
     * @param userId User ID (by default - current user).
     * @param randomId Unique identifier to avoid resending the message.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param peerIds IDs of message recipients. (See peer_id).
     * @param domain User's short address (for example, 'illarionov').
     * @param chatId ID of conversation the message will relate to.
     * @param message (Required if 'attachments' is not set.) Text of the message.
     * @param lat Geographical latitude of a check-in, in degrees (from -90 to 90).
     * @param long Geographical longitude of a check-in, in degrees (from -180 to 180).
     * @param attachment (Required if 'message' is not set.) List of objects attached to the message, separated by commas, in the following format: "<owner_id>_<media_id>", '' - Type of media attachment: 'photo' - photo, 'video' - video, 'audio' - audio, 'doc' - document, 'wall' - wall post, '<owner_id>' - ID of the media attachment owner. '<media_id>' - media attachment ID. Example: "photo100172_166443618".
     * @param replyTo 
     * @param forwardMessages ID of forwarded messages, separated with a comma. Listed messages of the sender will be shown in the message body at the recipient's. Example: "123,431,544".
     * @param forward JSON describing the forwarded message or reply.
     * @param stickerId Sticker id.
     * @param groupId Group ID (for group messages with group access token).
     * @param keyboard 
     * @param template 
     * @param payload 
     * @param contentSource JSON describing the content source in the message.
     * @param dontParseLinks 
     * @param disableMentions 
     * @param intent 
     * @param subscribeId 
     */
    suspend fun send(userId: Long? = null, randomId: Long? = null, peerId: Long? = null, peerIds: List<Int>? = null, domain: String? = null, chatId: Long? = null, message: String? = null, lat: Double? = null, long: Double? = null, attachment: String? = null, replyTo: Int? = null, forwardMessages: List<Int>? = null, forward: String? = null, stickerId: Long? = null, groupId: Long? = null, keyboard: String? = null, template: String? = null, payload: String? = null, contentSource: String? = null, dontParseLinks: Boolean? = false, disableMentions: Boolean? = false, intent: String? = "default", subscribeId: Long? = null): SendResponse {
        val response = method("send", mapOf("user_id" to userId, "random_id" to randomId, "peer_id" to peerId, "peer_ids" to peerIds, "domain" to domain, "chat_id" to chatId, "message" to message, "lat" to lat, "long" to long, "attachment" to attachment, "reply_to" to replyTo, "forward_messages" to forwardMessages, "forward" to forward, "sticker_id" to stickerId, "group_id" to groupId, "keyboard" to keyboard, "template" to template, "payload" to payload, "content_source" to contentSource, "dont_parse_links" to dontParseLinks, "disable_mentions" to disableMentions, "intent" to intent, "subscribe_id" to subscribeId))
        return SendResponse(response, json)
    }
    class SendResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(MessagesSendDeprecatedResponse.serializer(), MessagesSendUserIdsResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun MessagesSendDeprecatedResponse(): MessagesSendDeprecatedResponse?{
            return if (response is MessagesSendDeprecatedResponse) response else null
        }
        fun MessagesSendUserIdsResponse(): MessagesSendUserIdsResponse?{
            return if (response is MessagesSendUserIdsResponse) response else null
        }
    }

    /**
     *
     * @param eventId 
     * @param userId 
     * @param peerId 
     * @param eventData 
     */
    suspend fun sendMessageEventAnswer(eventId: String, userId: Long, peerId: Long, eventData: String? = null): BaseOkResponse {
        val response = method("sendMessageEventAnswer", mapOf("event_id" to eventId, "user_id" to userId, "peer_id" to peerId, "event_data" to eventData))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Send message reaction
     * 
     * @param peerId 
     * @param cmid 
     * @param reactionId 
     */
    suspend fun sendReaction(peerId: Long, cmid: Long, reactionId: Long): BaseBoolResponse {
        val response = method("sendReaction", mapOf("peer_id" to peerId, "cmid" to cmid, "reaction_id" to reactionId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Changes the status of a user as typing in a conversation.
     * 
     * @param userId User ID.
     * @param type 'typing' - user has started to type.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'chat_id', e.g. '2000000001'. For community: '- community ID', e.g. '-12345'. ".
     * @param groupId Group ID (for group messages with group access token).
     */
    suspend fun setActivity(userId: Long? = null, type: String? = null, peerId: Long? = null, groupId: Long? = null): BaseOkResponse {
        val response = method("setActivity", mapOf("user_id" to userId, "type" to type, "peer_id" to peerId, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Sets a previously-uploaded picture as the cover picture of a chat.
     * 
     * @param file Upload URL from the 'response' field returned by the [vk.com/dev/photos.getChatUploadServer|photos.getChatUploadServer] method upon successfully uploading an image.
     */
    suspend fun setChatPhoto(file: String): MessagesSetChatPhotoResponse {
        val response = method("setChatPhoto", mapOf("file" to file))
        return json.decodeFromString<MessagesSetChatPhotoResponse>(response)
    }

    /**
     *
     * @param peerId 
     * @param groupId 
     */
    suspend fun unpin(peerId: Long, groupId: Long? = null): BaseOkResponse {
        val response = method("unpin", mapOf("peer_id" to peerId, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
