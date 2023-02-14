package com.example.firstcodelabs.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

// Изначально нам доступны фигуры типа CornerBasedShape, но
// TODO("3.8 С помощью расширений мы можем создавать новые фигуры нужных нам типов.")
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)