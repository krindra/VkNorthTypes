package ru.krindra.vknorthtypes.types.database

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DatabaseGetCitiesResponse (
    val response: DatabaseGetCitiesRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class DatabaseGetCitiesRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<DatabaseCity>,
    )
}

