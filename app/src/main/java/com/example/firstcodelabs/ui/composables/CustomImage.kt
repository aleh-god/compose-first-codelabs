package com.example.firstcodelabs.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

@Composable
fun CustomImage(
    modifier: Modifier = Modifier
) {
    // TODO("7.3 Для рамки также необходимо указать форму")
    // и в данном случае необходимо чтобы форма совпадала с формой,
    // которую мы использовали, чтобы обрезать картинку.
    val customShape = RoundedCornerShape(percent = 25)

    // TODO("7.1 Для отображения картинок в Compose есть Image")
    // который может отрисовать как растровую, так и векторную графику.
    // В обоих случаях, с помощью painterResource получаем Painter.
    // Класс, который в Compose ответственный за отрисовку изображений на экране и передаем его в Image.
    // Второй обязательный параметр - contentDescription, используется для accessibility,
    // но не имеет значения по умолчанию и если вы его игнорируете, то нужно явно прописывать null.

    // Можно использовать параметр alignment, чтобы изменить расположение картинки в нашем контейнере
    // или указать тип масштабирования изображения c contentStacle - в данном случае None.
    // Можно также задать прозрачность или применить какой-либо цветовой фильтр, которых достаточно много.
    Image(
        painter = painterResource(id = R.drawable.pepeclown),
        contentDescription = null,
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit,
        alpha = 0.5f,
        colorFilter = ColorFilter.tint(
            Color.Yellow, BlendMode.Darken
        ),
        // TODO("7.2 Если же нужно обрезать картинку - то, это уже делаться через Modifier.")
        modifier = modifier
            .fillMaxWidth(0.5f)
            .clip(customShape)
            .border(
                BorderStroke(
                    width = 8.dp,
                    color = MaterialTheme.colors.primary
                ),
                customShape,
            )
    )
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
fun CustomImagePreview() {
    FirstCodelabsTheme {
        CustomImage()
    }
}
