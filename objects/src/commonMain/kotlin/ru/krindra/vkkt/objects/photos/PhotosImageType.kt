package ru.krindra.vkkt.objects.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Photo's type.
 * 
 */
@Serializable
enum class PhotosImageType(val value: String){
    @SerialName("s") S("s"),
    @SerialName("m") M("m"),
    @SerialName("x") X("x"),
    @SerialName("l") L("l"),
    @SerialName("o") O("o"),
    @SerialName("p") P("p"),
    @SerialName("q") Q("q"),
    @SerialName("r") R("r"),
    @SerialName("y") Y("y"),
    @SerialName("z") Z("z"),
    @SerialName("w") W("w"),
    @SerialName("base") BASE("base"),
}
