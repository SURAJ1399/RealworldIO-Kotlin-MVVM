package net.piedevelopers.api.request

import com.google.gson.annotations.SerializedName

data class SignupRequest(

        @SerializedName("user")
        val signupdata: SignupData
)