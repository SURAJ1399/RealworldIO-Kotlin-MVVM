package net.piedevelopers.api.response

data class User(
    val bio: String,
    val email: String,
    val image: String,
    val token: String,
    val username: String
)