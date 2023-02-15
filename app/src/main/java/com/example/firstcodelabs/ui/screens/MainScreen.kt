package com.example.firstcodelabs.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.composables.Accessibility
import com.example.firstcodelabs.ui.composables.Notification

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Notification(
            messageModifier = Modifier.padding(dimensionResource(id = R.dimen.padding_mini)),
            buttonModifier = Modifier.padding(dimensionResource(id = R.dimen.padding_mini)),
            textNotification = "Notification",
            clickNotification = {
                Log.i("TAG#", "NotificationPreview: clickNotification")
            }
        )

        Accessibility(
            onClickText = {
                Log.i("TAG#", "AccessibilityPreview: onClickText")
            },
            onClickButton = {
                Log.i("TAG#", "AccessibilityPreview: onClickButton")
            },
            onClickRadio = {
                Log.i("TAG#", "AccessibilityPreview: onClickRadio = $it")
            }
        )
    }
}
