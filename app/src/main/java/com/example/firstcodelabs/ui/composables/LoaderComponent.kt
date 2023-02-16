package com.example.firstcodelabs.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

@Composable
fun LoaderComponent(
    // Можно добавить Modifier, чтобы в месте вызова мы могли указать размер = Modifier.fillMaxSize()
    modifier: Modifier = Modifier,
    // Мы предполагаем, что в основном будет использоваться вариант с белым фоном, то мы добавили значение по умолчанию false для этого параметра.
    useTransparentBackground: Boolean = false
) {

    // Surface это также компонент из стандартной библиотеки, но это скорее даже не компонент,
    // а некая абстракция из Material Design. Это поверхность, у которой может быть какой-то цвет,
    // форма, высота. Интересный момент то, что
    // TODO("6.5 Под капотом Surface - это не что иное как Box, у которого propagateMinContraints установлен на true.")

    // TODO("6.8 У Surface есть еще одна очень важная особенность - она блокирует передачу нажатий на компоненты, которые расположены за ней.")
    // Это может быть очень полезно, если мы захотим сделать наш компонент более гибким,
    // показывать его над другими элементами и делая его фон полупрозрачным.
    Surface(
        // Для нашей поверхности минимальный размер - все пространство, которое ей доступно.
        modifier = modifier,
        // TODO("6.9 Мы легко можем ограничить выбор цвета, оставив ее внутри нашего компонента.")
        color = if (useTransparentBackground) Color.Black.copy(alpha = 0.3f)
            else MaterialTheme.colors.surface
    ) {
        // Так как propagateMinConstraints установлен на true - то получается, что
        // TODO("6.6 Surface передает свой размер нашим компонентам в качестве минимального")
        // и “растягивает” его до размера экрана.

        Box(
            // TODO("6.4 Кроме contentAlignment - также есть propagateMinConstraints. По умолчанию он установлен на false")
            propagateMinConstraints = false,
            contentAlignment = Alignment.Center
        ) {

            CircularProgressIndicator()

            Text(
                text = stringResource(R.string.app_name),
                // TODO("6.2 Можем переопределить некоторые параметры стиля, например размер, цвет или выравнивание.")
                style = MaterialTheme.typography.caption,
                fontSize = 20.sp,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center,
                // TODO("6.1 Управлять расположением элементов в Box можно также через Modifier каждого элемента.")
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(32.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoaderComponentPreview() {
    FirstCodelabsTheme {
        LoaderComponent(
            modifier = Modifier.fillMaxSize()
        )
    }
}

// TODO("6.3 Список параметров (относится непосредственно к стилю текста) комбинируется с заданным стилем, используя функцию style.merge")
/*
val mergedStyle = style.merge(
    TextStyle(
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign,
        lineHeight = lineHeight,
        fontFamily = fontFamily,
        textDecoration = textDecoration,
        fontStyle = fontStyle,
        letterSpacing = letterSpacing
    )
)
 */

