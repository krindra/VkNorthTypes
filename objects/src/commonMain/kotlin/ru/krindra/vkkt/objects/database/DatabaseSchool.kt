package ru.krindra.vkkt.objects.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id School ID
 * @param title School title
 */
@Serializable
data class DatabaseSchool (
    @SerialName("id") val id: Int? = null,
    @SerialName("title") val title: String? = null,
)
