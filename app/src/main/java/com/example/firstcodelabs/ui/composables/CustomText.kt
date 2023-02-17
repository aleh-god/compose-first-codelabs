package com.example.firstcodelabs.ui.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

// Кроме параметра с текстом, которым мы хотим показать, мы также создали параметр Modifier.
// За счет этого, в месте вызова - мы имеем доступ ко всем возможностям Modifier
// и можем легко кастомизировать то, как мы отображаем этот компонент.
// TODO("8.1 Добавление параметра Modifier - очень полезный паттерн.")
// который рекомендуется использовать когда вы пишете свои компоненты и
// широко используется в стандартной библиотеке.
// Причем, так как нам не всегда он может быть нужен, то общая рекомендация
// задавать для него пустой Modifier в качестве параметра по умолчанию.
// И таким образом, в месте вызова, если нужно мы его можем легко изменить,
// а если нет - то просто проигнорируем.

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CustomTextPreview() {
    FirstCodelabsTheme {
        CustomText("Whoops, we couldn't load the data!")
    }
}
