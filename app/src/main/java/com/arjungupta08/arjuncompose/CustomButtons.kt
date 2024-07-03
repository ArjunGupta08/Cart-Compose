package com.arjungupta08.arjuncompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationButton(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .background(color = Color.White)
            .clickable {
                onClick.invoke()
            }, shape = RoundedCornerShape(8.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(3.dp)
        )
    }
}

@Composable
fun TopFilterButton(
    item: Data.Item,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) colorResource(id = R.color.green) else colorResource(id = R.color.light_grey)

    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(29.dp)))
            .background(backgroundColor)
            .width(150.dp)
            .padding(8.dp)
            .clickable {
                onClick.invoke()
            }
    ) {
        Text(
            text = item.name,
            textAlign = TextAlign.Center,
            maxLines = 1,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
        )
    }
    Spacer(modifier = Modifier.width(5.dp))
}

@Composable
fun RoundedButton(
    imageVector: ImageVector,
    onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .clickable {
                onClick.invoke()
            }, shape = CircleShape
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(4.dp)
        )
    }
}

@Composable
fun CancelButton(
    text: String,
    onClick: () -> Unit
) {
    Surface(shape = RoundedCornerShape(CornerSize(18.dp)),
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(29.dp)))
            .background(colorResource(id = R.color.red))
            .width(145.dp)
            .padding(8.dp)
            .clickable {
                onClick.invoke()
            }
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            maxLines = 1,
            fontSize = 18.sp,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .background(colorResource(id = R.color.red))
                .padding(5.dp, 8.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun CheckoutButton(
    text: String,
    onClick: () -> Unit
) {
    Surface(shape = RoundedCornerShape(CornerSize(18.dp)),
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(29.dp)))
            .background(colorResource(id = R.color.orange))
            .width(225.dp)
            .padding(8.dp)
            .clickable {
                onClick.invoke()
            }
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            maxLines = 1,
            fontSize = 18.sp,
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .background(colorResource(id = R.color.orange))
                .padding(5.dp, 8.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun DashedDivider(
    modifier: Modifier = Modifier,
    dashWidth: Dp = 4.dp,
    dashHeight: Dp = 2.dp,
    gapWidth: Dp = 2.dp,
    color: Color = Color.Gray,
) {
    Canvas(modifier) {

        val pathEffect = PathEffect.dashPathEffect(
            intervals = floatArrayOf(dashWidth.toPx(), gapWidth.toPx()),
            phase = 0f
        )

        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect,
            strokeWidth = dashHeight.toPx()
        )
    }
}