package com.example.firstcodelabs.ui.composables

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

private const val HELP_TAG = "help_tag"
private const val ANNOTATION = "www.my-website.com/help"

// TODO("8.3 Мы решили не давать возможность передавать текст.")
// Для случая на экране, мы зададим значение для текста внутри самого компонента,
// так как предположили, что переиспользоваться он не будет.
@OptIn(ExperimentalTextApi::class)
@Composable
private fun ContactSupportText(
    onContactClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val annotatedString = buildAnnotatedString {
        append(stringResource(R.string.ui_widgets_support_text_append_1))
        append("\n")
        append(stringResource(R.string.ui_widgets_support_text_append_2))
        withStyle(
            SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.Blue
            )
        ) {
            // TODO("8.3 Добавим аннотацию, которая будет применена к тексту внутри лямбды.")
            // Из параметров у нее tag, который мы будем использовать и строка в качестве аннотации.
            withAnnotation(tag = HELP_TAG, annotation = ANNOTATION) {
                append(stringResource(R.string.ui_widgets_support_text_append_3))
            }
        }
    }

    ClickableText(
        text = annotatedString,
        // TODO("8.4 В лямбде, мы получаем offset, который указывает на место в тексте в котором пользователь нажал на текст.")
        onClick = { offset ->
            annotatedString
                // Далее, мы можем получить список аннотаций, который есть у нашего текста с данным отступом.
                // Мы хотим получить только аннотации с нашим тэгом, поэтому указываем непосредственно его.
                .getStringAnnotations(HELP_TAG, offset, offset)
                .firstOrNull()
                ?.let { annotation ->
                    // Если такие аннотации имеются, то мы получаем доступ к самому значению аннотации.
                    onContactClicked(annotation.item)
                }
        },
        // Выравнивание по центру, мы также могли добиться не только здесь,
        // но и применив его к тексту с аннотацией, когда его создавали
        style = TextStyle.Default.merge(
            TextStyle(textAlign = TextAlign.Center)
        ),
        modifier = modifier,
        )
}

@Preview(showBackground = true)
@Composable
fun ContactSupportTextPreview() {
    FirstCodelabsTheme {
        ContactSupportText(
            onContactClicked = {
                Log.i("TAG#", "ContactSupportText: onContactClicked = $it")
            }
        )
    }
}
