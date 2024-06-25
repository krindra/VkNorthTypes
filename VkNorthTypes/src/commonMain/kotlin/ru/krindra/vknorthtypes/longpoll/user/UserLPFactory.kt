package ru.krindra.vknorthtypes.longpoll.user

import kotlinx.serialization.json.*
import ru.krindra.vknorthtypes.JsonSingleton
import ru.krindra.vknorthtypes.longpoll.user.updates.*

object UserLPFactory {
    fun fromEvent(rawEvent: String): List<UserLPUpdate> {
        val updates = mutableListOf<UserLPUpdate>()
        val rawUpdates = JsonSingleton.json
            .parseToJsonElement(rawEvent)
            .jsonObject["updates"]!!
            .jsonArray

        for (rawUpdate in rawUpdates)
            updates.add(fromJsonArray(rawUpdate.jsonArray))

        return updates
    }

    fun fromJsonArray(jsonArray: JsonArray): UserLPUpdate {
        val id = jsonArray[0].jsonPrimitive.int
        val list = JsonArray(jsonArray.drop(1))
        println(list)
        return when (id) {
            1 -> ReplaceMessageFlagsUpdate.fromJsonArray(list)
            2 -> SetMessageFlagsUpdate.fromJsonArray(list)
            3 -> ResetMessageFlagsUpdate.fromJsonArray(list)
            4 -> MessageNewUpdate.fromJsonArray(list)
            5 -> MessageEditUpdate.fromJsonArray(list)
            6 -> ReadIncomingMessagesUpdate.fromJsonArray(list)
            7 -> ReadOutgoingMessagesUpdate.fromJsonArray(list)
            8 -> FriendOnlineUpdate.fromJsonArray(list)
            9 -> FriendOfflineUpdate.fromJsonArray(list)
            10 -> ResetDialogFlagsUpdate.fromJsonArray(list)
            11 -> ReplaceDialogFlagsUpdate.fromJsonArray(list)
            12 -> SetDialogFlagsUpdate.fromJsonArray(list)
            13 -> DeleteDialogMessagesUpdate.fromJsonArray(list)
            14 -> RestoreDialogMessagesUpdate.fromJsonArray(list)
            20 -> ChangeMajorIdUpdate.fromJsonArray(list)
            21 -> ChangeMinorIdUpdate.fromJsonArray(list)
            51 -> ChatSettingsChangeUpdate.fromJsonArray(list)
            52 -> ChatInfoChangedUpdate.fromJsonArray(list)
            61 -> UserTypingInDialogUpdate.fromJsonArray(list)
            62 -> UserTypingInChatUpdate.fromJsonArray(list)
            63 -> UsersTypingInChatUpdate.fromJsonArray(list)
            64 -> UserVoiceRecordingUpdate.fromJsonArray(list)
            70 -> UserCallUpdate.fromJsonArray(list)
            80 -> ChangeCountOfUnreadDialogsUpdate.fromJsonArray(list)
            114 -> NotificationChangeUpdate.fromJsonArray(list)
            else -> UnknownUpdate(id, jsonArray)
        }
    }
}