package br.com.fishtudo.devhub.ui.screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fishtudo.devhub.ui.screen.component.uistate.ProfileUiState

@Composable
fun RepositoryContainer(profileState: ProfileUiState, paddingHorizontal: Dp, paddingTop: Dp) {
    if (profileState.repositories.isNotEmpty()) {
        Text(
            text = "Repositórios",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 15.dp,
                    start = paddingHorizontal,
                    end = paddingHorizontal
                ),
        )
        profileState.repositories.forEach {
            Column(
                modifier = Modifier.padding(
                    start = paddingHorizontal,
                    end = paddingHorizontal,
                    top = paddingTop
                )
            ) {
                RepositoryItem(githubRepositoryUiState = it)
            }
        }
        Spacer(modifier = Modifier.size(paddingTop))
    }
}