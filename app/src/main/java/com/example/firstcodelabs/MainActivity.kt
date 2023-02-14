package com.example.firstcodelabs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.firstcodelabs.ui.composables.Notification
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Однако из обычных Kotlin функций вызвать Composable не получится.
        // Поэтому в compose есть специальное расширение setContent, которое вы можете вызвать в Activity.
        setContent {
            FirstCodelabsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Notification(
                        messageModifier = Modifier.padding(dimensionResource(id = R.dimen.padding_mini)),
                        buttonModifier = Modifier.padding(dimensionResource(id = R.dimen.padding_mini)),
                        textNotification = "Notification",
                        clickNotification = {
                            Log.i("TAG#", "NotificationPreview: clickNotification")
                        }
                    )
                }
            }
        }
    }
}
