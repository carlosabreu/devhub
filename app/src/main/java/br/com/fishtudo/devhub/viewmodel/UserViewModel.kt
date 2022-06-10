package br.com.fishtudo.devhub.viewmodel

import br.com.fishtudo.devhub.repository.RetrofitInitializer
import br.com.fishtudo.devhub.repository.data.User
import br.com.fishtudo.devhub.util.GITHUB_USERNAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel {

    fun requestUserDataWithCallback(): MutableStateFlow<User> {
        val data: MutableStateFlow<User> = MutableStateFlow(User())
        val call =
            RetrofitInitializer().githubService().requireUserDataUsingCallbacks(GITHUB_USERNAME)
        call.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                response.body()?.let {
                    data.tryEmit(it)
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
            }
        })
        return data
    }

    fun requestUserDataWithCoroutines(): MutableStateFlow<User> {
        val data: MutableStateFlow<User> = MutableStateFlow(User())

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitInitializer().githubService().requireUserDataUsingCoroutines(GITHUB_USERNAME)
                .body()?.let { data.tryEmit(it) }
        }
        return data
    }
}