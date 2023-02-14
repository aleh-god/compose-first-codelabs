package com.example.firstcodelabs.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Типографику из material theme можно настроить несколькими способами:
// Первый способ - создать новый инстанс Typography из пакета material
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

// TODO("3.5 Второй способ настроить Типографику - создать расширение.")
// Стили текста в Typography из пакета material так же, как и цвета ограничены.
// И если вам нужен совершенно новый стиль, то без расширения не обойтись.
val Typography.newStyle: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

// TODO("3.8 Собственный шрифт можно использовать в наших стилях типографики.")
val Typography.myStyle: TextStyle
    get() = TextStyle(
        fontFamily = NewFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

