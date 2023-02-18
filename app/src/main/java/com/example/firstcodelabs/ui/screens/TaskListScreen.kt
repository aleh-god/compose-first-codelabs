package com.example.firstcodelabs.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.firstcodelabs.ui.composables.tasklist.SearchField

@Composable
fun TaskListScreen() {
    SearchField(
        searchQuery = "some text",
        onQueryChange = {
            Log.i("TAG#", "SearchField: onQueryChange = $it")
        }
    )
}
