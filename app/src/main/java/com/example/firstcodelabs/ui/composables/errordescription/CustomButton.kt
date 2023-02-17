package com.example.firstcodelabs.ui.composables.errordescription

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.Dimensions
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

// TODO("9.1 Эта функция обертка над стандартной кнопкой, в которой переопределены цвета и задана рамка.")
// Соответственно, при добавлении compose в свой проект, можно аналогичным образом сделать обертку,
// которая будет соответствовать вашей дизайн-системе и уже использовать ее повсеместно.

@Composable
fun CustomButton(
    // TODO("9.2 Из параметров, которые нам нужны - текст для кнопки, лямбда для действия, Modifier для настройки и иконка.")
    buttonLabel: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int? = null,
) {
    // TODO("9.3 Для компонентов Button, есть два обязательных параметра - onClick и Composable лямбда content.")
    Button(
        onClick = onClick,
        // Форму кнопки, можно изменить с помощью параметра shape и, например, задать скргуление для углов.
        shape = RoundedCornerShape(size = Dimensions.padding_medium),
        // Чтобы сделать края полностью круглыми, можем задать скругление в процентах, указав 50.
        // shape = RoundedCornerShape(percent = 50),
        // Для кнопки, мы можем также изменить внутренние отступы с помощью параметра contentPadding
        contentPadding = PaddingValues(
            horizontal = Dimensions.padding_main,
            vertical = Dimensions.custom_padding_vertical_button
        ),
        // Или изменить цвета с помощью параметра colors.
        // Тут стоит отметить еще один паттерн, который часто встречается в стандартной библиотеке -
        // TODO("9.5 Паттерн - Группировка параметров с помощью вспомогательных классов.")
        // Если посмотреть на функцию Button, то в ней три таких вспомогательных параметра -
        // elevation, colors и contentPadding и каждый из которых содержит несколько значений
        // TODO("9.6 Cоветую объединять схожие по смыслу параметры, когда будете создавать свои компоненты.")
        // это действительно очень удобно и часто упрощает работу с компонентами.
        colors = ButtonDefaults.run {
            buttonColors(
                backgroundColor = Color.Yellow, // disabledBackgroundColor
                contentColor = Color.Black, // disabledContentColor
            )
        },
        modifier = modifier
    ) {

        // TODO("9.5 Кроме традиционного параметра Modifier у Column и Row есть два других")
        // которые отвечают за расположение элементов внутри ряда.
        // Если же нам нужно задать отступ между элементами индивидуально, то тут у нас два варианта:
        // Использовать Modifier.padding для конкретного элемента, которому нужен отступ.
        // Или добавит между элементами Spacer - компонент из стандартной библиотеки,
        // который представляет собой пустой View.

        // TODO("9.9 Tак как мы вместо Arrangement.SpaceBetween переходим на weight - в итоге, необходимость в Row отпадает.")
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, // TODO("9.7 у этого параметра есть небольшая проблема. Если текст у кнопки будет слишком длинным, то он вытолкнет иконку за пределы экрана.")
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // TODO("9.4 Content - добавлена как Composable функция для гибкости.")
            // И она дает нам возможность вызвать любую другую Composable функцию внутри.
            // Более того, для Button - она объявлена как extension функция к RowScope.
            // Соответственно, мы крайне легко можем добавить иконку справа от нашей кнопки просто вызвав соответствующую функцию.
            Text(
                text = buttonLabel,
                modifier = Modifier.weight(1f) // TODO("9.8 Решить это можно с помощью Modifier.weight")
            // Работает он следующим образом.
            // Вначале, в ряде (или колонке) будут расположены элементы у которых вес не задан.
            // Далее, оставшееся доступное пространство будет распределено между компонентами у которых вес есть.
            // В данном случае - такой компонент один. И за счет этого текст займет все доступное пространство,
            // но при этом не будет выталкивать иконку, которую свое место получило первой.
            )
            // И показывать иконку только если при вызове было передано соответствующее значение.
            iconId?.let {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    modifier = Modifier.padding(start = Dimensions.padding_small)
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CustomButtonPreview() {
    FirstCodelabsTheme {
        CustomButton(
            buttonLabel = "текст займет все доступное пространство, но при этом не будет выталкивать иконку, которую свое место получило первой.",
            onClick = {
                Log.i("TAG#", "CustomButton: onClick")
            },
            iconId = R.drawable.baseline_refresh_24
        )
    }
}
