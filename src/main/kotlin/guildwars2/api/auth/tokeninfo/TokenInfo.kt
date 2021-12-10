package guildwars2.api.auth.tokeninfo

data class TokenInfo(
    val id: String?,
    val name: String?,
    val permissions: List<String>
)