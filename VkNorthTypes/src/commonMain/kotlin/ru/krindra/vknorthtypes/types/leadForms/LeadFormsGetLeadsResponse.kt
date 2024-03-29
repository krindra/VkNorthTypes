package ru.krindra.vknorthtypes.types.leadForms

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LeadFormsGetLeadsResponse (
    val response: LeadFormsGetLeadsRawResponse
) {
    /**
     *
     * @param leads 
     * @param nextPageToken 
     */
    @Serializable
    data class LeadFormsGetLeadsRawResponse (
        @SerialName("leads") val leads: List<LeadFormsLead>,
        @SerialName("next_page_token") val nextPageToken: String? = null,
    )
}

