package com.example.firstcodelabs.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/*
Иногда бывает полезно посмотреть как интерфейс будет выглядеть с различными данными.
Для этого есть PreviewParameterProvider.
Имплементируя этот интерфейс необходимо переопределить параметр values и перечислить данные, которые вам надо проверить.
После создания ParameterProvider нужно добавить аргумент с аннотацией PreviewParameter в Preview функцию и использовать в качестве параметра нашей Composable функции.
    @PreviewParameter(HelloPreviewParameterProvider::class)
    hello: String
 */

class HelloPreviewParameterProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        "Compose", "Android"
    )
}
