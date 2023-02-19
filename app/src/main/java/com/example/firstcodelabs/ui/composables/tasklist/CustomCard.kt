package com.example.firstcodelabs.ui.composables.tasklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstcodelabs.R
import com.example.firstcodelabs.ui.theme.Dimensions
import com.example.firstcodelabs.ui.theme.FirstCodelabsTheme

@Composable
fun CustomCard(
    title: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(Dimensions.rounded_small),
        modifier = modifier.padding(Dimensions.padding_mini)
    ) {
        Column(Modifier.fillMaxWidth()) {
            // TODO("12.1 Иногда нужно знать размер дочерних элементов до того, как их расположить на экране.")
            // Суть Intrinsics заключается в том, что у любого Composable есть минимальный
            // и максимальный размер, который ему нужен для корректной отрисовки.
            // IntrinsicSize.Min / IntrinsicSize.Max позволяет родителю узнать эту информацию,
            // чтобы, например, определить свои размеры.
            // В примере на экране, мы хотели бы задать высоту верхнего ряда до того,
            // как расположить в ней разделитель, чтобы он не растянул его.
            // Для этого мы указываем, что она равна IntricticsSize.Min.
            // Тогда наш ряд узнает минимальный размер, который нужен дочерним элементам -
            // в данном случае, для текста это будет высота строки, для разделителя это ноль,
            // а для иконки мы сами задали размер через Modifier.size.
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(Dimensions.padding_small)
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .weight(1f)
                )
                Divider(
                    modifier = Modifier
                        // TODO("12.2 Теперь можем спокойно указать, что наш разделитель должен занять максимально допустимый размер с помощью fillMaxHeight.")
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_done_24),
                    contentDescription = stringResource(
                        R.string.ui_card_cont_descr_done_icon
                    ),
                    modifier = Modifier.size(Dimensions.custom_size_big)
                )
            }
            Divider()
            Text(
                text = text,
                modifier = Modifier.padding(Dimensions.padding_small)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomCardPreview() {
    FirstCodelabsTheme {
        CustomCard(
            title = "13 Feb",
            text = "Task 1 description"
        )
    }
}