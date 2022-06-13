package br.com.fishtudo.devhub.viewmodel

import androidx.lifecycle.ViewModel
import br.com.fishtudo.devhub.network.RetrofitInitializer
import br.com.fishtudo.devhub.ui.screen.component.uistate.ProfileUiState
import br.com.fishtudo.devhub.ui.screen.component.uistate.RepositoryUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val data: MutableStateFlow<ProfileUiState> = MutableStateFlow(ProfileUiState())

    fun findProfileBy(userName: String) {
        requestUserData(userName)
        requestRepositories(userName)
    }

    private fun requestUserData(userName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                RetrofitInitializer().githubService().requireUserDataUsingCoroutines(userName)
            response.body()?.let {
                data.tryEmit(ProfileUiState.from(it, data.value.repositories))
            }
        }
    }

    private fun requestRepositories(userName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                RetrofitInitializer().githubService().requireRepos(userName)
            response.body()?.let { githubRepositoryList ->

                val repoUiState = githubRepositoryList.map {
                    RepositoryUiState.from(it)
                }
                val copy = data.value.copy()
                copy.repositories = repoUiState
                data.tryEmit(copy)
            }
        }
    }
}