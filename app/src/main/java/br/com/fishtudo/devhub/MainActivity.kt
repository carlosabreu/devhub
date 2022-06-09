package br.com.fishtudo.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import br.com.fishtudo.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
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
            Image(
                painterResource(id = R.drawable.github_profile),
                contentDescription = "Imagem do usuário",
                modifier = Modifier
                    .align(BottomCenter)
                    .height(imageHeight)
                    .offset(x = 0.dp, y = offSet)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
        }

        Spacer(modifier = Modifier.size(offSet))

        Text(
            text = "Carlos Abreu",
            fontSize = 35.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "carlosabreu",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Mobile developer at Banco do Brasil!",
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevHubTheme {
        ProfileScreen()
    }
}