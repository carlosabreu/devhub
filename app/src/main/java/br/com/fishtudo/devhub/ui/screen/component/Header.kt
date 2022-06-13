package br.com.fishtudo.devhub.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.fishtudo.devhub.R
import br.com.fishtudo.devhub.ui.screen.component.uistate.ProfileUiState
import br.com.fishtudo.devhub.ui.screen.component.uistate.RepositoryUiState
import br.com.fishtudo.devhub.ui.theme.DevHubTheme
import br.com.fishtudo.devhub.util.IMAGE_DESCRIPTION
import coil.compose.AsyncImage

@Composable
fun Header(imageUrl: String, boxHeight: Dp) {
    val imageHeight = remember { boxHeight }
    val corner = remember { 15.dp }
    val offSet = remember { boxHeight / 2 }

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
            model = imageUrl,
            contentDescription = IMAGE_DESCRIPTION,
            placeholder = painterResource(R.drawable.user_placeholder),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(imageHeight)
                .width(imageHeight)
                .offset(x = 0.dp, y = offSet)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }

    Spacer(modifier = Modifier.size(offSet))
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    DevHubTheme {
        Header("", 8.dp)
    }
}