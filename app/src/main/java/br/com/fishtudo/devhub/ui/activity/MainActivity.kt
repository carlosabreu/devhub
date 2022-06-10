package br.com.fishtudo.devhub.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fishtudo.devhub.R
import br.com.fishtudo.devhub.viewmodel.UserViewModel
import br.com.fishtudo.devhub.repository.data.User
import br.com.fishtudo.devhub.ui.theme.DevHubTheme
import br.com.fishtudo.devhub.util.IMAGE_DESCRIPTION
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    var viewModel: UserViewModel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen(viewModel.requestUserDataWithCallback())
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(state: MutableStateFlow<User>) {
    val user: State<User> = state.collectAsState()

    Column {
        val boxHeight = remember {
            150.dp
        }

        val imageHeight = remember {
            boxHeight
        }

        val corner = remember {
            15.dp
        }

        val offSet = remember {
            boxHeight / 2
        }

        Box {
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(0.dp, 0.dp, corner, corner))
                    .background(Color(0xFF393939))
                    .height(boxHeight)
            )
            AsyncImage(
                model = user.value.avatar_url,
                contentDescription = IMAGE_DESCRIPTION,
                placeholder = painterResource(R.drawable.user_placeholder),
                modifier = Modifier
                    .align(BottomCenter)
                    .height(imageHeight)
                    .width(imageHeight)
                    .offset(x = 0.dp, y = offSet)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
        }


        Spacer(modifier = Modifier.size(offSet))

        Text(
            text = user.value.name,
            fontSize = 35.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = user.value.login,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = user.value.bio,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val mockedUser = User("Nome", "Login", "Biografia")
    DevHubTheme {
        ProfileScreen(MutableStateFlow(mockedUser))
    }
}