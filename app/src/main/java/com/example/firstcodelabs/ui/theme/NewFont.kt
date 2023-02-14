package com.example.firstcodelabs.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.firstcodelabs.R

// Часто в приложениях необходимо поддержать собственные или другие лицензированные шрифты.
// Для них точно так же, как и в темах на XML, необходимо добавить эти шрифты в ресурсы приложения.
// TODO("3.7 Для собственного шрифта создается объект FontFamily.")
val NewFont = FontFamily(
    Font(R.font.new_regular, FontWeight.Normal),
    Font(R.font.new_regular, FontWeight.Bold),
)
