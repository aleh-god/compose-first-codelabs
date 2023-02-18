package com.example.firstcodelabs.ui.composables

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.composables.errordescription.ContactSupportText
import com.example.firstcodelabs.ui.composables.errordescription.CustomImage
import com.example.firstcodelabs.ui.composables.errordescription.CustomText
import com.example.firstcodelabs.ui.composables.errordescription.TextWithBoldSuffix
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

// TODO("10.1 Сначала объединим верхнюю часть screen в отдельную функцию ErroDesciption.")
// На вход она будет принимать все нужные данные и Modifier.
@Composable
fun ErrorDescription(
    title: String,
    errorCode: String,
    onReportClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // TODO("10.2 Настроим Column известным образом и разместим все элементы по середине.")
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        // Добавим в нее все элементы, которые мы подготовили
        CustomImage()
        CustomText(title)
        TextWithBoldSuffix(stringResource(R.string.ui_error_description_subtitle), errorCode)
        ContactSupportText(
            onContactClicked = onReportClicked
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
fun ErrorDescriptionPreview() {
    FirstCodelabsTheme {
        ErrorDescription(
            title = "Whoops, we couldn't load the data!",
            errorCode = "AA-31",
            onReportClicked = {
                Log.i("TAG#", "ErrorDescription: onReportClicked = $it")
            }
        )
    }
}
