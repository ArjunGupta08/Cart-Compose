package com.arjungupta08.arjuncompose.items


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjungupta08.arjuncompose.Data


@Composable
fun ItemOrder(
    data: Data.Food,
    onClick : () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(9.dp),
        modifier = Modifier
            .width(220.dp)
            .wrapContentHeight()
            .padding(start = 10.dp, end = 10.dp, top = 5.dp)
            .background(Color.White)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .width(220.dp)
                .height(210.dp)
                .background(color = Color.White)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = data.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
                    .background(Color.Red)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Column {
                    Text(
                        text = data.name,
                        style = TextStyle(
                            fontSize = 19.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "${data.price} €", style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    )
                }
            }

        }
    }
}

