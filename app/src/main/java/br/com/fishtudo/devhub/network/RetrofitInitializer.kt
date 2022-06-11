package br.com.fishtudo.devhub.network


import br.com.fishtudo.devhub.network.service.GithubService
import br.com.fishtudo.devhub.util.GITHUB_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun githubService(): GithubService =
        retrofit.create(GithubService::class.java)
}