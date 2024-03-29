package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Owner id
 * @param href Href
 * @param name Name
 * @param photo Photo
 * @param verify Verify
 * @param gender Gender
 * @param nameGet Name get
 * @param firstName First name
 * @param firstNameGen First name gen
 * @param firstNameIns First name ins
 * @param canFollow Can follow
 */
@Serializable
data class AdsStoriesOwner (
    @SerialName("first_name_ins") val firstNameIns: String? = null,
    @SerialName("name_get") val nameGet: String? = null,
    @SerialName("can_follow") val canFollow: Boolean? = null,
    @SerialName("photo") val photo: String? = null,
    @SerialName("href") val href: String? = null,
    @SerialName("id") val id: Long? = null,
    @SerialName("verify") val verify: String? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("first_name_gen") val firstNameGen: String? = null,
    @SerialName("firstName") val firstName: String? = null,
)
