package com.example.firstcodelabs.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firstcodelabs.ui.composables.loadercomponent.LoaderComponent

@Composable
fun WidgetsScreen() {
    LoaderComponent(
        // TODO("6.10 Самому можно компоненту добавить параметр Boolean для переключения между цветами.")
        useTransparentBackground = true,
        // TODO("6.7 чтобы его было легче переиспользовать - можно обернуть его в Surface и добавить Modifier, чтобы в месте вызова мы могли указать размер.")
        // Теперь мы можем растянуть его на все доступное пространство через тот же Modifier.fillMaxSize() в месте вызова компонента
        modifier = Modifier.fillMaxSize()
        // Или задать ему определенный размер через просто Modifier.size() в зависимости от того, что нам нужно.
        // modifier = Modifier.size(width = 100.dp, height = 200.dp)
    )
}
