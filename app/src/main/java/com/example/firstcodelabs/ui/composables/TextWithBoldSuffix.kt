package com.example.firstcodelabs.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

@Composable
fun TextWithBoldSuffix(
    prefix: String,
    suffix: String,
    modifier: Modifier = Modifier
) {
    Text(
        // TODO("8.2 Text принимает на вход строку с аннотациями - AnnotatedString.")
        // Для добавления стилей, есть два варианта
        text = buildAnnotatedString {
            // 1. Использовать функцию с лямбдой
            withStyle(SpanStyle(fontWeight = FontWeight.Light)) {
                append(prefix)
            }
            // 2. Можно добавлять стили с помощью pushStyle, и потом убирать их, используя pop.
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
            append(suffix)
            pop(0)
        },
        modifier = modifier
    )
}

@Preview(
    showBackground = true
)
@Composable
fun TextWithBoldSuffixPreview() {
    FirstCodelabsTheme {
        TextWithBoldSuffix("Error code: ", "AA-31")
    }
}
