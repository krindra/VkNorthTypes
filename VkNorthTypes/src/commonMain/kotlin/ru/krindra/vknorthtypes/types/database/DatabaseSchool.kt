package ru.krindra.vknorthtypes.types.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id School ID
 * @param title School title
 */
@Serializable
data class DatabaseSchool (
    @SerialName("id") val id: Long? = null,
    @SerialName("title") val title: String? = null,
)
