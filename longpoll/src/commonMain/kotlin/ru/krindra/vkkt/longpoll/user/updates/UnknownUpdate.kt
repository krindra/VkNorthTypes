package ru.krindra.vkkt.longpoll.user.updates

import kotlinx.serialization.json.JsonArray

data class UnknownUpdate(
    val id: Int,
    val raw: JsonArray
): UserLPUpdate()
