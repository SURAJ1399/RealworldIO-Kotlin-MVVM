package net.piedevelopers.api.response

data class User(
    val bio: String,
    val email: String,
    val image: Any,
    val token: String,
    val username: String
)