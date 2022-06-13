package br.com.fishtudo.devhub.ui.screen.component.uistate

import br.com.fishtudo.devhub.network.data.GithubRepository

data class RepositoryUiState(
    val name: String,
    val description: String = "",
) {
    companion object {
        fun from(githubRepository: GithubRepository): RepositoryUiState {
            return RepositoryUiState(
                name = githubRepository.name ?: "",
                description = githubRepository.description ?: ""
            )
        }
    }
}