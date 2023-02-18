package com.example.firstcodelabs.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.composables.ErrorDescription
import com.example.firstcodelabs.ui.composables.errordescription.CustomButton
import com.example.firstcodelabs.ui.theme.Dimensions

// TODO("10.3 Далее нужно объединить верхнюю часть с кнопкой.")
@Composable
fun ErrorScreen() {
    // Для этого, мы можем поместить оба элемента в еще одну колонку.
    Column(Modifier.fillMaxSize()) {
        ErrorDescription(
            title = stringResource(R.string.ui_error_screen_title),
            errorCode = "AA-31",
            onReportClicked = {
                Log.i("TAG#", "ErrorDescription: onReportClicked = $it")
            },
            // И используем Modifier у каждого из них, чтобы немного настроить.
            modifier = Modifier
                .fillMaxWidth()
                // для верхней части добавим уже знакомый нам Modifier.weight,
                // чтобы верхняя часть заняла все свободное пространство после добавления кнопки.
                .weight(1f)
        )
        CustomButton(
            buttonLabel = stringResource(R.string.button_text_refresh),
            onClick = {
                Log.i("TAG#", "CustomButton: onClick")
            },
            iconId = R.drawable.baseline_refresh_24,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimensions.padding_medium,
                    vertical = Dimensions.custom_padding_big_vertical_button
                )
        )
    }
}
