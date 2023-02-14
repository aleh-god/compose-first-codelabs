package com.example.firstcodelabs.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

// TODO("3.2 Цвета для Compose проектов нужно объявлять свойства в Kotlin файлах.")
// Цвета объявляются по следующим правилам:
// Первые два символа 0x сообщают компилятору, что это шестнадцатеричное число
// Вторые два символа представляют прозрачность в шестнадцатеричном формате
// Остальные шесть символов представляют красный, зеленый и синий цвета

val Navy = Color(0xFF060047)
val Red = Color(0xFFB3005E)
val Pink = Color(0xFFE90064)
val PinkLight = Color(0xFFFF5F9E)

// TODO("3.4 Если необходимо добавить новый цвет, создайте расширение.")
val Colors.newColor: Color
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xFF000000)
