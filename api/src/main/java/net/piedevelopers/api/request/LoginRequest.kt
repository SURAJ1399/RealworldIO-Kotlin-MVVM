package net.piedevelopers.api.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
        @SerializedName( "user")
    val loginData: LoginData
)