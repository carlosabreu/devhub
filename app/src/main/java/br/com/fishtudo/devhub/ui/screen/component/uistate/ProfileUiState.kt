package br.com.fishtudo.devhub.ui.screen.component.uistate

import br.com.fishtudo.devhub.network.data.GithubUser

data class ProfileUiState(
    var user: String = "",
    var image: String = "",
    var name: String = "",
    var bio: String = "",
    var repositories: List<RepositoryUiState> = emptyList()
) {
    companion object {
        fun from(
            githubUser: GithubUser,
            repositories: List<RepositoryUiState>
        ): ProfileUiState {
            return ProfileUiState(
                user = githubUser.login,
                image = githubUser.avatar,
                name = githubUser.name,
                bio = githubUser.bio,
                repositories = repositories
            )
        }
    }
}