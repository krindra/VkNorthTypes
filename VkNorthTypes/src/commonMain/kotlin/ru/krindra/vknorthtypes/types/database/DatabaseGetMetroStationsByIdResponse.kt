package ru.krindra.vknorthtypes.types.database

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.Serializable

typealias DatabaseGetMetroStationsByIdRawResponse = List<DatabaseStation>
@Serializable
data class DatabaseGetMetroStationsByIdResponse (
    val response: DatabaseGetMetroStationsByIdRawResponse
)

