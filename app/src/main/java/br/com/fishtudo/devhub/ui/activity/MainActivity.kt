package br.com.fishtudo.devhub.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import br.com.fishtudo.devhub.ui.screen.ProfileScreen
import br.com.fishtudo.devhub.ui.theme.DevHubTheme
import br.com.fishtudo.devhub.util.GITHUB_USERNAME
import br.com.fishtudo.devhub.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    private var viewModel: UserViewModel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen(GITHUB_USERNAME, viewModel)
                }
            }
        }
    }
}