package br.com.fishtudo.devhub.repository.service

import br.com.fishtudo.devhub.repository.data.User
import br.com.fishtudo.devhub.util.PATH_LIST_USER
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET(PATH_LIST_USER)
    fun requireUserDataUsingCallbacks(@Path("userName") userName: String): Call<User>

    @GET(PATH_LIST_USER)
    suspend fun requireUserDataUsingCoroutines(@Path("userName") userName: String): Response<User>
}
