package br.com.fishtudo.devhub.ui.screen

import br.com.fishtudo.devhub.network.data.GithubUser

data class ProfileUiState(
    val user: String,
    val image: String,
    val name: String,
    val bio: String
) {
    companion object {
        fun from(githubUser: GithubUser): ProfileUiState {
            return ProfileUiState(
                user = githubUser.login,
                image = githubUser.avatar,
                name = githubUser.name,
                bio = githubUser.bio
            )
        }
    }
}