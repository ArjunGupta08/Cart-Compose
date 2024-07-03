package com.arjungupta08.arjuncompose.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjungupta08.arjuncompose.Data
import com.arjungupta08.arjuncompose.RoundedButton

@Composable
fun ItemCart(
    cartData: Data.Food,
    onQuantityChange : (quantity : Int) -> Unit,
    quantity: Int
) {
    Card(
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(9.dp),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cartData.img), contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(CornerSize(9.dp)))
            )

            Column(
                modifier = Modifier.fillMaxWidth(0.6f)
                    .padding(start = 15.dp, end = 0.dp)
            ) {
                Text(
                    text = cartData.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                )
                Text(
                    text = "${cartData.price} €", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            RoundedButton(imageVector = Icons.Default.Remove) {
                onQuantityChange.invoke(-1)
            }

            Text(
                text = "${quantity}", style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .width(25.dp)
            )

            RoundedButton(imageVector = Icons.Filled.Add) {
                onQuantityChange.invoke(1)
            }

        }
    }


}