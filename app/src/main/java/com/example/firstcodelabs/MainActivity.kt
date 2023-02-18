package com.example.firstcodelabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firstcodelabs.ui.screens.ErrorScreen
import com.example.firstcodelabs.ui.screens.MainScreen
import com.example.firstcodelabs.ui.screens.WidgetsScreen
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Однако из обычных Kotlin функций вызвать Composable не получится.
        // Поэтому в compose есть специальное расширение setContent, которое вы можете вызвать в Activity.
        setContent {
            FirstCodelabsTheme {
                // TODO("0. ")
//                MainScreen()
//                WidgetsScreen()
                ErrorScreen()
            }
        }
    }
}
