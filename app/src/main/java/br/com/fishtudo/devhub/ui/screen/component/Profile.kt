package br.com.fishtudo.devhub.ui.screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fishtudo.devhub.ui.screen.component.uistate.ProfileUiState
import br.com.fishtudo.devhub.ui.screen.component.uistate.RepositoryUiState
import br.com.fishtudo.devhub.ui.theme.DevHubTheme

@Composable
fun Profile(profileState: ProfileUiState) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        val boxHeight = remember { 150.dp }
        val paddingTop = remember { 15.dp }
        val paddingHorizontal = remember { 4.dp }

        Header(
            imageUrl = profileState.image,
            boxHeight = boxHeight,
        )

        Text(
            text = profileState.name,
            fontSize = 35.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = profileState.user,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = profileState.bio,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = paddingHorizontal, end = paddingHorizontal)
        )

        RepositoryContainer(profileState, paddingHorizontal, paddingTop)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val profileUiState =
        ProfileUiState(
            name = "Carlitos",
            user = "carlosabreu",
            bio = "Mobile developer at Banco do Brasil!",
            image = "",
            repositories = listOf(RepositoryUiState("Repository 1", ""))
        )
    DevHubTheme {
        Profile(profileUiState)
    }
}