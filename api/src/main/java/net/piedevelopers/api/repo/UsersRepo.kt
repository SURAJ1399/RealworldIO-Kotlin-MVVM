package net.piedevelopers.api.repo

import net.piedevelopers.api.RetrofitClient
import net.piedevelopers.api.request.SignupData
import net.piedevelopers.api.request.SignupRequest
import net.piedevelopers.api.response.User

object  UsersRepo {
    val retrofitClient = RetrofitClient()
//
//    suspend fun signup(username: String, email: String, password: String): User? {
//        val response = retrofitClient.api.signupUser(SignupRequest(SignupData(
//                email, password, username
//        )))
//
//        // TODO: Save it in SharedPreferences
//        ConduitClient.authToken = response.body()?.user?.token
//
//        return response.body()?.user
//
//    }
}