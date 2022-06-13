package br.com.fishtudo.devhub.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fishtudo.devhub.ui.screen.component.uistate.RepositoryUiState
import br.com.fishtudo.devhub.ui.theme.DevHubTheme

@Composable
fun RepositoryItem(githubRepositoryUiState: RepositoryUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column {
            Text(
                text = githubRepositoryUiState.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2d333b))
                    .padding(16.dp),
                fontSize = 24.sp,
                color = Color.White
            )
            if (githubRepositoryUiState.description.isNotBlank()) {
                Text(
                    githubRepositoryUiState.description,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepositoryPreview() {
    val repositoryUiState =
        RepositoryUiState(
            name = "DevHub",
            description = "Devhub project description",
        )
    DevHubTheme {
        RepositoryItem(repositoryUiState)
    }
}