package br.com.fishtudo.devhub.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import br.com.fishtudo.devhub.network.data.GithubUser
import br.com.fishtudo.devhub.ui.theme.DevHubTheme
import br.com.fishtudo.devhub.viewmodel.UserViewModel

@Composable
fun ProfileScreen(userName: String, viewModel: UserViewModel) {
    val mutableStateFlow = remember {
        viewModel.requestUserDataWithCoroutines(userName)
    }
    val githubUser: GithubUser = mutableStateFlow.collectAsState().value
    val profileUiState: ProfileUiState = ProfileUiState.from(githubUser)
    Profile(profileUiState)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val profileUiState =
        ProfileUiState(
            name = "Carlitos",
            user = "carlosabreu",
            bio = "Mobile developer at Banco do Brasil!",
            image = ""
        )
    DevHubTheme {
        Profile(profileUiState)
    }
}