package ru.krindra.vknorthtypes.types.polls

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param anonymous 
 * @param friends 
 * @param multiple Information whether the poll with multiple choices
 * @param answerId Current user's answer ID
 * @param endDate 
 * @param answerIds Current user's answer IDs
 * @param closed 
 * @param isBoard 
 * @param canEdit 
 * @param canVote 
 * @param canReport 
 * @param canShare 
 * @param embedHash 
 * @param photo 
 * @param answers 
 * @param created Date when poll has been created in Unixtime
 * @param id Poll ID
 * @param ownerId Poll owner's ID
 * @param authorId Poll author's ID
 * @param question Poll question
 * @param background 
 * @param votes Votes number
 * @param disableUnvote 
 */
@Serializable
data class PollsPoll (
    @SerialName("can_report") val canReport: Boolean,
    @SerialName("photo") val photo: PollsBackground? = null,
    @SerialName("answer_id") val answerId: Long? = null,
    @SerialName("anonymous") val anonymous: PollsPollAnonymous? = null,
    @SerialName("can_share") val canShare: Boolean,
    @SerialName("embed_hash") val embedHash: String? = null,
    @SerialName("can_vote") val canVote: Boolean,
    @SerialName("author_id") val authorId: Long? = null,
    @SerialName("background") val background: PollsBackground? = null,
    @SerialName("can_edit") val canEdit: Boolean,
    @SerialName("answers") val answers: List<PollsAnswer>,
    @SerialName("question") val question: String,
    @SerialName("votes") val votes: Int,
    @SerialName("end_date") val endDate: Int,
    @SerialName("is_board") val isBoard: Boolean,
    @SerialName("disable_unvote") val disableUnvote: Boolean,
    @SerialName("owner_id") val ownerId: Long,
    @SerialName("closed") val closed: Boolean,
    @SerialName("friends") val friends: List<PollsFriend>? = null,
    @SerialName("created") val created: Int,
    @SerialName("answer_ids") val answerIds: List<Int>? = null,
    @SerialName("multiple") val multiple: Boolean,
    @SerialName("id") val id: Long,
)
