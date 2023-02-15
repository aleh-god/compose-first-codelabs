package com.example.firstcodelabs.ui.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.stateDescription

// Интерактивные элементы по умолчанию не предоставляют никакой информации о том, что будет делать клик по этому элементу.
// Поэтому службы специальных возможностей, например, TalkBack, будут использовать общее описание по умолчанию.

@Composable
fun Accessibility(
    onClickText: () -> Unit,
    onClickButton: () -> Unit,
    onClickRadio: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    radioModifier: Modifier = Modifier,
) {

    val buttonLabel = stringResource(R.string.ui_accessibility_label_text)
    val radioDescrFasle = stringResource(R.string.ui_accessibility_state_descr_radio_fasle)
    val radioDescrTrue = stringResource(R.string.ui_accessibility_state_descr_radio_true)
    var radioState by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_small))
    ) {

        Text(
            // TODO("5.1 Мы можем предоставить конкретное описание, объясняющее, что произойдет, когда пользователь нажмет на элемент")
            // для этого необходимо элементу установить модификатор clickable и пердать ему параметр onClickLabel
            modifier = textModifier.clickable(
                onClickLabel = stringResource(R.string.ui_accessibility_label_text),
                onClick = onClickText
            ),
            text = stringResource(R.string.ui_accessibility_main_text)
        )

        // Некоторые стандартные элементы (такие как Button) могут использовать для клика собственный параметр onClick.
        // TODO("5.2 Для предоставления информации службам специальных возможностей нам необходимо поменять на modifier semantics")
        Button(
            modifier = buttonModifier.semantics {
                onClick(
                    label = buttonLabel
                ) { true }
            },
            onClick = onClickButton
        ) {
            Text(text = stringResource(R.string.button_text_play))
        }

        // TODO("5.3 Для изображений можно использовать свойство contentDescription")
        // которое работает аналогично тегу из xml.
        Icon(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = stringResource(R.string.ui_accessibility_cont_descr_button_play)
        )

        // TODO("5.4 С помощью stateDescription мы можем описать элемент, который может иметь разные состояния")
        RadioButton(
            modifier = radioModifier.semantics {
                stateDescription = if (radioState) radioDescrTrue else radioDescrFasle
            },
            selected = radioState,
            onClick = {
                radioState = !radioState
                onClickRadio(radioState)
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AccessibilityPreview() {
    FirstCodelabsTheme {
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
