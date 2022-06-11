package br.com.fishtudo.devhub.viewmodel

import br.com.fishtudo.devhub.network.RetrofitInitializer
import br.com.fishtudo.devhub.network.data.GithubUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel {

    fun requestUserDataWithCallback(userName: String): MutableStateFlow<GithubUser> {
        val data: MutableStateFlow<GithubUser> = MutableStateFlow(GithubUser())
        val call =
            RetrofitInitializer().githubService().requireUserDataUsingCallbacks(userName)
        call.enqueue(object : Callback<GithubUser?> {
            override fun onResponse(call: Call<GithubUser?>, response: Response<GithubUser?>) {
                response.body()?.let {
                    data.tryEmit(it)
                }
            }

            override fun onFailure(call: Call<GithubUser?>, t: Throwable) {
            }
        })
        return data
    }

    fun requestUserDataWithCoroutines(userName: String): MutableStateFlow<GithubUser> {
        val data: MutableStateFlow<GithubUser> = MutableStateFlow(GithubUser())

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitInitializer().githubService().requireUserDataUsingCoroutines(userName)
                .body()?.let { data.tryEmit(it) }
        }
        return data
    }
}