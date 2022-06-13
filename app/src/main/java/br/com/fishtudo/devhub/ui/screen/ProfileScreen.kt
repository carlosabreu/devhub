package br.com.fishtudo.devhub.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import br.com.fishtudo.devhub.ui.screen.component.Profile
import br.com.fishtudo.devhub.ui.screen.component.uistate.ProfileUiState
import br.com.fishtudo.devhub.ui.theme.DevHubTheme
import br.com.fishtudo.devhub.viewmodel.UserViewModel

@Composable
fun ProfileScreen(userName: String, viewModel: UserViewModel) {
    val mutableStateFlow = viewModel.data
    LaunchedEffect(key1 = null) {
        viewModel.findProfileBy(userName)
    }
    Profile(mutableStateFlow.collectAsState().value)
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