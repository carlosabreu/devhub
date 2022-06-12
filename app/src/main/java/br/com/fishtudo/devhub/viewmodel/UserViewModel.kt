package br.com.fishtudo.devhub.viewmodel

import br.com.fishtudo.devhub.network.RetrofitInitializer
import br.com.fishtudo.devhub.network.data.GithubUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel {
    fun requestUserDataWithCoroutines(userName: String): MutableStateFlow<GithubUser> {
        val data: MutableStateFlow<GithubUser> = MutableStateFlow(GithubUser())
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                RetrofitInitializer().githubService().requireUserDataUsingCoroutines(userName)
            response.body()?.let {
                data.tryEmit(it)
            }
        }
        return data
    }
}