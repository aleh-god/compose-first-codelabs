package com.example.firstcodelabs.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.preview.HelloPreviewParameterProvider
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Greeting(
    name: String,
    count: Int
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            // TODO("2.6 А вот аналогичный метод для загрузки цветов (colorResource)")
            // лучше использовать только во время переходного периода.
            // Если у вас проект полностью на Compose - отдавайте предпочтение цветам из темы.
            .background(color = colorResource(R.color.teal_200)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            // TODO("2.3 Для загрузки текста надо вызывать метод stringResource. "Hello $name!" ")
            text = stringResource(id = R.string.hello_template, name)
        )

        Text(
            // plurals строки так же объявляются в ресурсах и загружаются при помощи метода pluralStringResource.
            text = pluralStringResource(R.plurals.jetpack, count, count),
            //  TODO("2.4 Чтобы извлечь значение dimen - вызовите метод dimensionResource.")
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding)),
            // TODO("2.5 НЕЛЬЗЯ загружать размеры текста в sp через метод dimensionResource")
            // можно воспользоваться расширением toSp(), которое объявлено в интерфейсе Density.
            // Этот интерфейс предоставляет плотность экрана и коэффициент масштабирования для шрифтов, который пользователь может установить в настройках.
            // Экземпляр Density можно получить через свойство LocalDensity, которое доступно в Composable функциях.
            fontSize = with(LocalDensity.current) {
                dimensionResource(id = R.dimen.fontSize32).toSp()
            }
        )

        Image(
            // TODO("2.6 Для загрузки изображений из ресурсов существует метод painterResource.")
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }
}

// TODO("2.1 У preview есть достаточно обширный набор параметров")
// с помощью которого вы можете смотреть как будет выглядеть ваша composable функция в разной конфигурации устройства.
@Preview(
    showBackground = true,
    fontScale = 2f,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    // showSystemUi = true
)
@Composable
fun DefaultPreview(
    // TODO("2.2 Иногда бывает полезно посмотреть как интерфейс будет выглядеть с различными данными.")
    // Для этого есть PreviewParameterProvider.
    @PreviewParameter(HelloPreviewParameterProvider::class)
    hello: String
) {
    FirstCodelabsTheme {
        Greeting(hello, 2)
    }
}