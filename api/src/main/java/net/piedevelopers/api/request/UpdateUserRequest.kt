package net.piedevelopers.api.request

import com.google.gson.annotations.SerializedName

data class UpdateUserRequest(
        @SerializedName("user")
    val user: UserRequest
)