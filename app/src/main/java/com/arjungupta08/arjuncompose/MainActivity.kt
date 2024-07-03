package com.arjungupta08.arjuncompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjungupta08.arjuncompose.items.ItemCart
import com.arjungupta08.arjuncompose.items.ItemOrder
import com.arjungupta08.arjuncompose.ui.theme.ArjunComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArjunComposeTheme {
                SplitScreen()
            }
        }
    }
}

@Composable
fun SplitScreen() {

    val addedItemList = remember { mutableStateListOf<Data.Food>() }

    // Calculate total amount
    val totalAmount by remember {
        derivedStateOf {
            addedItemList.sumOf { it.price * it.quantity.value }
        }
    }

    // Custom Filter Buttons
    var selectedItem by remember { mutableStateOf<Data.Item?>(null) }

    Row(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            modifier = Modifier
                .weight(0.63f)
                .fillMaxHeight()
                .padding(8.dp)
        ) {

            // First Part Header - Order
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            ) {

                // Nav to Left
                NavigationButton(imageVector = Icons.Filled.KeyboardArrowLeft) {

                }

                LazyRow(
                    modifier = Modifier
                        .width(620.dp)
                        .padding(top = 8.dp)
                ) {
                    items(Data.itemList) { item ->
                        TopFilterButton(
                            item = item,
                            isSelected = selectedItem == item
                        ) {
                            selectedItem = item
                        }
                    }
                }

                // Nav to Right
                NavigationButton(imageVector = Icons.Filled.KeyboardArrowRight) {

                }

                // Search Button
                RoundedButton(imageVector = Icons.Filled.Search) {

                }
            }

            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
                    .padding(0.dp, 4.dp, 0.dp, 0.dp)
                )

                LazyVerticalGrid(
                    modifier = Modifier.background(Color.White),
                    columns = GridCells.Fixed(4), content = {
                    items(
                        items = when (selectedItem?.name) {
                            "Juice" -> {
                                Data.juiceList
                            }
                            "Cakes" -> {
                                Data.cakeList
                            }
                            "IceCream" -> {
                                Data.iceCreamList
                            }
                            "Chocolates" -> {
                                Data.chocolateList
                            }
                            else -> {
                                Data.dataList
                            }
                        }
                    ) {
                        ItemOrder(data = it) {
                            val isSelected = addedItemList.contains(it)
                            if (isSelected) {
                                addedItemList.remove(it)
                            } else {
                                addedItemList.add(it)
                            }
                        }
                    }
                })
        }
        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .width(3.dp)
        )

        // Second Part - Cart
        Column(
            modifier = Modifier
                .weight(0.37f)
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            HeaderSecond()
            Divider(
                color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
                .padding(0.dp, 9.dp, 0.dp, 0.dp)
            )
        /*--------------------Customize your Order--------------------*/

            LazyColumn(
                modifier = Modifier
                    .background(Color.White)
                    .heightIn(0.dp, 350.dp) ){
                        itemsIndexed(addedItemList) { index, it ->
                            key(index) {
                                ItemCart(cartData = it, onQuantityChange = {onQuantityChange->
                                    if (onQuantityChange < 0) {
                                        if (it.quantity.value == 1) {
                                            addedItemList.remove(it)
                                        } else {
                                            it.quantity.value--
                                        }
                                    } else {
                                        it.quantity.value++
                                    }
                                },it.quantity.value)
                            }
                        }
                }
            /*-------------------------------------------*/

            Row(modifier = Modifier
                .padding(start = 15.dp, top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Toppings : ",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                 )
                Text(text = "Topping 1, Topping 2, Topping 3",
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                 )
            }

            Row(modifier = Modifier
                .padding(start = 15.dp, top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Note : ",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                 )
                Text(text = "This is a Note",
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                 )
            }

/*-----------------Footer----------------------------------*/
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)){
                Column(modifier = Modifier
                    .align(Alignment.BottomStart)
                ) {
                    DashedDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    )
                    Row (modifier = Modifier
                        .background(Color.White)
                        .padding(start = 10.dp, bottom = 35.dp, top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Total Price",
                            modifier =  Modifier.fillMaxWidth(0.70f),
                            style = TextStyle(
                                fontSize = 22.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        )

                            Text(
                                text = "$totalAmount €",
                                style = TextStyle(
                                    fontSize = 28.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.ExtraBold,
                                    textAlign = TextAlign.End
                                ),
                                modifier = Modifier.width(100.dp)
                            )
                    }

                    Footer()
                }
            }
        }
    }
}

// Second Half header
@Composable
fun HeaderSecond(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .background(Color.White)
                .padding(3.dp)
        ) {
            Text(
                text = "Order Details", style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Your Cart", style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                )
            )
        }
        Text(
            text = "Table", style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "A01", style = TextStyle(
                fontSize = 38.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

// Footer
@Composable
fun Footer() {

    Row (modifier = Modifier
        .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ){
        CancelButton(text = "Cancel") {
//            Toast.makeText(, "", Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.width(40.dp))
        CheckoutButton(text = "Checkout") {
            
        }
    }
}

@Preview(name = "Tablet Preview", device = "spec:width=1280dp,height=800dp,dpi=480")
@Composable
fun GreetingPreview() {
    ArjunComposeTheme {
        SplitScreen()
    }
}