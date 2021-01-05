package net.piedevelopers.api.repo

import android.util.Log
import net.piedevelopers.api.RetrofitClient
import net.piedevelopers.api.request.*
import net.piedevelopers.api.response.User


object  UsersRepo {

    val retrofitClient = RetrofitClient()

    suspend fun signup(username: String, email: String, password: String) =
            retrofitClient.api.signupUser(
                    SignupRequest(SignupData(
                            email, password, username)
                    )
            )

    suspend fun login(email: String, password: String): User? {
        val response = retrofitClient.api.loginUser(
                LoginRequest(LoginData(
                        email, password)
                )
        )

        retrofitClient.authToken = response.body()?.user?.token
        Log.i("token", response.body()?.user?.token)
        return response.body()?.user

    }

    suspend fun updateUser(
            bio: String?,
            username: String?,
            image: String?,
            email: String?,
            password: String?
    ): User? {
        val response = retrofitClient.authapi.updateuser(UpdateUserRequest(UserRequest(
                bio, email, image, username, password
        )))

        return response.body()?.user
    }

    suspend fun getCurrentUser(token: String): User? {
        retrofitClient.authToken = token
      val response=retrofitClient.authapi.getCurrentUser().body()?.user
        Log.i("response", response.toString())
        return  response
    }
}



