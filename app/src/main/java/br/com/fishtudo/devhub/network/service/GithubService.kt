package br.com.fishtudo.devhub.network.service

import br.com.fishtudo.devhub.network.data.GithubRepository
import br.com.fishtudo.devhub.network.data.GithubUser
import br.com.fishtudo.devhub.util.PATH_LIST_USER
import br.com.fishtudo.devhub.util.PATH_REPOS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET(PATH_LIST_USER)
    suspend fun requireUserDataUsingCoroutines(@Path("userName") userName: String): Response<GithubUser>

    @GET(PATH_REPOS)
    suspend fun requireRepos(@Path("userName") userName: String): Response<List<GithubRepository>>
}
