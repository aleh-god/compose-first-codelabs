package com.example.firstcodelabs.ui.composables.tasklist

import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

// Compose декларативный фреймворк. Он всегда будет отображать то, что мы ему передаем в качестве состояния.

// TODO("11.1 В первую очередь посмотрим на поле ввода, которое можно добавить с помощью TextField.")
// Еще стоит сказать, что у TextField есть альтернативная версия c рамкой - OutlinedTextField.
// А если же возможностей для настройки внешнего вида TextField и OutlinedTextField нам не достаточно
// или они нам не подходят по какой-то причине, то есть более низкоуровневый компонент BasicTextField,
// который можно использовать и уже полностью настроить под свои нужды.
@Composable
fun SearchField(
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    // TODO("11.2 Данный паттерн в Compose называется slot API.")
    // Возможность передать любую Composable функцию, дает очень большую гибкость,
    // так что это еще один паттерн, который точно стоит запомнить
    // и, при необходимости, применять для своих компонентов.
    label: @Composable (() -> Unit)? = {
        Text(text = stringResource(R.string.ui_search_field_label))
    },
    placeholder: @Composable (() -> Unit)? = {
        Text(text = stringResource(R.string.ui_search_field_placeholder))
    },
    leadingIcon: @Composable (() -> Unit)? = {
        Icon(
            painter = painterResource(R.drawable.baseline_search_24),
            contentDescription = stringResource(R.string.ui_search_field_cont_descr_leading_icon)
        )
    },
    trailingIcon: @Composable (() -> Unit)? = {
        Icon(
            painter = painterResource(id = R.drawable.baseline_last_page_24),
            contentDescription = stringResource(R.string.ui_search_field_cont_descr_trailing_icon)
        )
    },
) {

    // TODO("11.4 Получив FocusManager, мы можем реагировать на действия пользователя на экране.")
    val focusManager = LocalFocusManager.current

    // TODO("11.5 Eще один полезный навык это умение показывать клавиатуру через FocusRequester")
    val focusRequester = remember { FocusRequester() }
    // И в нужный нам момент вызвать функцию requestFocus.
    LaunchedEffect(Unit) { focusRequester.requestFocus() }

    TextField(
        value = searchQuery,
        onValueChange = onQueryChange,
        // Добавляем его к компоненту, для которого мы хотим запросить фокус, используя Modifier.focusRequester
        modifier = modifier.focusRequester(focusRequester),
        textStyle = MaterialTheme.typography.body2,
        singleLine = true,
        // Параметр c помощью которого мы можем изменить такие вещи как: Тип клавиатуры,
        // отключить автоисправление и указать действие главной кнопки на клавиатуре.
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            capitalization = KeyboardCapitalization.None,
            autoCorrect = false,
            imeAction = ImeAction.Search,
        ),
        // TODO("11.3 Чтобы отреагировать на действие imeAction нужно переопределить параметр keyboardActions.")
        keyboardActions = KeyboardActions(
            onSearch = {
                // и в лямбде вызвать нужный нам метод.
                // focusManager.moveFocus(FocusDirection.Next)
                focusManager.clearFocus(force = true)
            }
        ),
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Preview(
    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_NO,
//    showSystemUi = true
)
@Composable
fun SearchFieldPreview() {
    FirstCodelabsTheme {
        SearchField(
            searchQuery = "some text",
            onQueryChange = {
                Log.i("TAG#", "SearchField: onQueryChange = $it")
            }
        )
    }
}
