package com.example.firstcodelabs.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.firstcodelabs.R
import com.example.firstcodelabs.data.datasource.TasksSource
import com.example.firstcodelabs.ui.composables.errordescription.CustomButton
import com.example.firstcodelabs.ui.composables.tasklist.CustomCard
import com.example.firstcodelabs.ui.composables.tasklist.SearchField
import com.example.firstcodelabs.ui.theme.Dimensions
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskListScreen() {

    val coroutineScope = rememberCoroutineScope()

    // TODO("13.8 Для управления скроллом - списки используют LazyListState.")
    val listState = rememberLazyListState()
    // TODO("13.9 Дает возможность реагировать на изменения состояния, например - узнать когда происходит скролл.")
    if (listState.isScrollInProgress) {
        Log.i("TAG#", "TaskListScreen: Scroll In Progress")
    }

    Column {

        SearchField(
            searchQuery = "some text",
            onQueryChange = {
                Log.i("TAG#", "SearchField: onQueryChange = $it")
            },
            modifier = Modifier.fillMaxWidth()
        )

        // TODO("13.1 У нас есть возможность использовать ленивые списки.")
        LazyColumn(
            state = listState,
            verticalArrangement = Arrangement.spacedBy(Dimensions.custom_space),
            contentPadding = PaddingValues(Dimensions.padding_small),
            modifier = Modifier.weight(1f)
        ) {
            /*
            // TODO("13.2 В отличии от Column и Row, каждый элемент нужно обернуть в item.")

            repeat(7) {
                item {
                    CustomCard(
                        title = "1$it Feb",
                        text = "Task $it description"
                    )
                }
            }

            // TODO("13.3 Можно использовать библиотечный оператор items, передавая ему коллекцию.")

            items(TasksSource.getTasks(5)) { task ->
                CustomCard(
                    title = task.date,
                    text = task.description
                )
            }
             */

            // TODO("13.4 Можем добавить заголовки, сгрупировав наши задачи по датам.")
            val tasksByDate = TasksSource.getHandMadeTasks().groupBy { it.date }
            tasksByDate.forEach { (date, taskList) ->
                // TODO("13.5 Если применим stickyHeader, то получим ленивые заголовки.")
                stickyHeader {
                    Text(
                        text = date,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = Dimensions.padding_small,
                                vertical = Dimensions.padding_micro
                            )
                            .background(color = MaterialTheme.colors.primary)
                    )
                }
                // TODO("13.6 Ключ, также советую передавать даже если вы анимации не используете")
                // так как с его помощью Compose может проводить различные оптимизации,
                // так что если ваши данные имеют такой уникальный ключ - то не забывайте его передать.
                items(taskList, key = { it.id }) { task ->
                    CustomCard(
                        title = task.date,
                        text = task.description,
                        // TODO("13.7 Добавить анимацию для перемещения элементов можно с Modifier.animateItemPlacement.")
                        modifier = Modifier.animateItemPlacement()
                    )
                }
            }
        }

        // TODO("13.10 Или для того, чтобы изменить это состояние. например при нажатии на кнопку - проскроллить список в начало.")
        CustomButton(
            buttonLabel = stringResource(R.string.ui_task_list_screen_button_label_move_top),
            onClick = {
                coroutineScope.launch { listState.animateScrollToItem(0) }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.padding_small)
        )
    }
}
