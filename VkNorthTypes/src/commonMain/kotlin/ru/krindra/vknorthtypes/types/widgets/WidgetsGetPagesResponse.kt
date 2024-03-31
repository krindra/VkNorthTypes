package ru.krindra.vknorthtypes.types.widgets

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WidgetsGetPagesResponse (
    val response: WidgetsGetPagesRawResponse
) {
    /**
     *
     * @param count Total number
     * @param pages 
     */
    @Serializable
    data class WidgetsGetPagesRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("pages") val pages: List<WidgetsWidgetPage>,
    )
}

