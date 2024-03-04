package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.users.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Users(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Returns detailed information on users.
     * 
     * @param userIds User IDs or screen names ('screen_name'). By default, current user ID.
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen', 'activity', 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities', 'can_invite_to_chats'.
     * @param nameCase Case for declension of user name and surname: 'nom' - nominative (default), 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' - prepositional.
     */
    suspend fun get(userIds: List<String>? = null, fields: List<UsersFields>? = null, nameCase: String? = null): UsersGetResponse {
        val response = method("get", mapOf("user_ids" to userIds, "fields" to fields, "name_case" to nameCase))
        return json.decodeFromString<UsersGetResponse>(response)
    }

    /**
     *
     * Returns a list of IDs of followers of the user in question, sorted by date added, most recent first.
     * 
     * @param userId User ID.
     * @param offset Offset needed to return a specific subset of followers.
     * @param count Number of followers to return.
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online'.
     * @param nameCase Case for declension of user name and surname: 'nom' - nominative (default), 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' - prepositional.
     */
    suspend fun getFollowers(userId: Long? = null, offset: Int? = null, count: Int? = 100, fields: List<UsersFields>? = null, nameCase: String? = null): GetfollowersResponse {
        val response = method("getFollowers", mapOf("user_id" to userId, "offset" to offset, "count" to count, "fields" to fields, "name_case" to nameCase))
        return GetfollowersResponse(response, json)
    }
    class GetfollowersResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(UsersGetFollowersFieldsResponse.serializer(), UsersGetFollowersResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun UsersGetFollowersFieldsResponse(): UsersGetFollowersFieldsResponse?{
            return if (response is UsersGetFollowersFieldsResponse) response else null
        }
        fun UsersGetFollowersResponse(): UsersGetFollowersResponse?{
            return if (response is UsersGetFollowersResponse) response else null
        }
    }

    /**
     *
     * Returns a list of IDs of users and communities followed by the user.
     * 
     * @param userId User ID.
     * @param extended '1' - to return a combined list of users and communities, '0' - to return separate lists of users and communities (default).
     * @param offset Offset needed to return a specific subset of subscriptions.
     * @param count Number of users and communities to return.
     * @param fields 
     */
    suspend fun getSubscriptions(userId: Long? = null, extended: Boolean? = false, offset: Int? = null, count: Int? = 20, fields: List<UsersFields>? = null): GetsubscriptionsResponse {
        val response = method("getSubscriptions", mapOf("user_id" to userId, "extended" to extended, "offset" to offset, "count" to count, "fields" to fields))
        return GetsubscriptionsResponse(response, json)
    }
    class GetsubscriptionsResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(UsersGetSubscriptionsExtendedResponse.serializer(), UsersGetSubscriptionsResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun UsersGetSubscriptionsExtendedResponse(): UsersGetSubscriptionsExtendedResponse?{
            return if (response is UsersGetSubscriptionsExtendedResponse) response else null
        }
        fun UsersGetSubscriptionsResponse(): UsersGetSubscriptionsResponse?{
            return if (response is UsersGetSubscriptionsResponse) response else null
        }
    }

    /**
     *
     * Reports (submits a complain about) a user.
     * 
     * @param userId ID of the user about whom a complaint is being made.
     * @param type Type of complaint: 'porn' - pornography, 'spam' - spamming, 'insult' - abusive behavior, 'advertisement' - disruptive advertisements.
     * @param comment Comment describing the complaint.
     */
    suspend fun report(userId: Long, type: String, comment: String? = null): BaseOkResponse {
        val response = method("report", mapOf("user_id" to userId, "type" to type, "comment" to comment))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns a list of users matching the search criteria.
     * 
     * @param q Search query string (e.g., 'Vasya Babich').
     * @param sort Sort order: '1' - by date registered, '0' - by rating.
     * @param offset Offset needed to return a specific subset of users.
     * @param count Number of users to return.
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online',.
     * @param city City ID.
     * @param cityId City ID. Use parameter city instead.
     * @param country Country ID.
     * @param countryId Country ID. Use parameter country instead.
     * @param hometown City name in a string.
     * @param universityCountry ID of the country where the user graduated.
     * @param university ID of the institution of higher education.
     * @param universityYear Year of graduation from an institution of higher education.
     * @param universityFaculty Faculty ID.
     * @param universityChair Chair ID.
     * @param sex '1' - female, '2' - male, '0' - any (default).
     * @param status Relationship status: '0' - Not specified, '1' - Not married, '2' - In a relationship, '3' - Engaged, '4' - Married, '5' - It's complicated, '6' - Actively searching, '7' - In love, '8' - In a civil union.
     * @param ageFrom Minimum age.
     * @param ageTo Maximum age.
     * @param birthDay Day of birth.
     * @param birthMonth Month of birth.
     * @param birthYear Year of birth.
     * @param online '1' - online only, '0' - all users.
     * @param hasPhoto '1' - with photo only, '0' - all users.
     * @param schoolCountry ID of the country where users finished school.
     * @param schoolCity ID of the city where users finished school.
     * @param schoolClass 
     * @param school ID of the school.
     * @param schoolYear School graduation year.
     * @param religion Users' religious affiliation.
     * @param company Name of the company where users work.
     * @param position Job position.
     * @param groupId ID of a community to search in communities.
     * @param fromList 
     * @param screenRef 
     */
    suspend fun search(q: String? = null, sort: Int? = null, offset: Int? = null, count: Int? = 20, fields: List<UsersFields>? = null, city: Int? = null, cityId: Long? = null, country: Int? = null, countryId: Long? = null, hometown: String? = null, universityCountry: Int? = null, university: Int? = null, universityYear: Int? = null, universityFaculty: Int? = null, universityChair: Int? = null, sex: Int? = null, status: Int? = null, ageFrom: Int? = null, ageTo: Int? = null, birthDay: Int? = null, birthMonth: Int? = null, birthYear: Int? = null, online: Boolean? = false, hasPhoto: Boolean? = false, schoolCountry: Int? = null, schoolCity: Int? = null, schoolClass: Int? = null, school: Int? = null, schoolYear: Int? = null, religion: String? = null, company: String? = null, position: String? = null, groupId: Long? = null, fromList: List<String>? = null, screenRef: String? = null): UsersSearchResponse {
        val response = method("search", mapOf("q" to q, "sort" to sort, "offset" to offset, "count" to count, "fields" to fields, "city" to city, "city_id" to cityId, "country" to country, "country_id" to countryId, "hometown" to hometown, "university_country" to universityCountry, "university" to university, "university_year" to universityYear, "university_faculty" to universityFaculty, "university_chair" to universityChair, "sex" to sex, "status" to status, "age_from" to ageFrom, "age_to" to ageTo, "birth_day" to birthDay, "birth_month" to birthMonth, "birth_year" to birthYear, "online" to online, "has_photo" to hasPhoto, "school_country" to schoolCountry, "school_city" to schoolCity, "school_class" to schoolClass, "school" to school, "school_year" to schoolYear, "religion" to religion, "company" to company, "position" to position, "group_id" to groupId, "from_list" to fromList, "screen_ref" to screenRef))
        return json.decodeFromString<UsersSearchResponse>(response)
    }

}
