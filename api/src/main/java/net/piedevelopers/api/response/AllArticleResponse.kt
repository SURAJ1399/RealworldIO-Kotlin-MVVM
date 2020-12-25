package net.piedevelopers.api.response

data class AllArticleResponse(
    val articles: List<Article>,
    val articlesCount: Int
)