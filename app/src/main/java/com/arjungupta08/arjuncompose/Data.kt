package com.arjungupta08.arjuncompose

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object Data {
    class Food(
        @DrawableRes var img:Int,
        var name : String,
        var price : Double,
        val quantity: MutableState<Int> = mutableStateOf(1)
    )

    var dataList = listOf(
        Food(R.drawable.mango_juice,"Mango Juice",30.00),
        Food(R.drawable.mixed_juice,"Mixed Fruit",30.00),
        Food(R.drawable.apple_juice,"Apple Juice",30.00),
        Food(R.drawable.chocolate_cake,"Strawberry Cake",102.00),
        Food(R.drawable.chocolate_cake,"Chocolate Cake",100.00),
        Food(R.drawable.tier_cake,"2 Tier Cake",110.00),
        Food(R.drawable.forest_cake,"Forest Cake",200.00),
        Food(R.drawable.sunadey,"Sundey",50.00),
        Food(R.drawable.vadilal,"Vadilal",25.00),
        Food(R.drawable.amul_ice,"Amul IceCream",10.00),
        Food(R.drawable.nut_choco,"Nut Chocolate",20.00),
        Food(R.drawable.dairy_milk,"Dairy Milk",5.00),
        Food(R.drawable.dark_choco,"Dark Chocolate",12.00),
        Food(R.drawable.wafer_choco,"Wafers",10.00)
    )

    var juiceList = listOf(
        Food(R.drawable.mango_juice,"Mango Juice",30.00),
        Food(R.drawable.mixed_juice,"Mixed Fruit",30.00),
        Food(R.drawable.apple_juice,"Apple Juice",30.00)
    )
    var cakeList = listOf(
        Food(R.drawable.chocolate_cake,"Strawberry Cake",102.00),
        Food(R.drawable.chocolate_cake,"Chocolate Cake",100.00),
        Food(R.drawable.tier_cake,"2 Tier Cake",110.00),
        Food(R.drawable.forest_cake,"Forest Cake",200.00)
    )
    var iceCreamList = listOf(
        Food(R.drawable.sunadey,"Sundey",50.00),
        Food(R.drawable.vadilal,"Vadilal",25.00),
        Food(R.drawable.amul_ice,"Amul IceCream",10.00)
    )
    var chocolateList = listOf(
        Food(R.drawable.nut_choco,"Nut Chocolate",20.00),
        Food(R.drawable.dairy_milk,"Dairy Milk",5.00),
        Food(R.drawable.dark_choco,"Dark Chocolate",12.00),
        Food(R.drawable.wafer_choco,"Wafers",10.00)
    )

    class Item(
        var id : Int,
        var name : String
    )

    var itemList = listOf(
        Item(0,"Cakes"),
        Item(1,"Juice"),
        Item(2,"IceCream"),
        Item(3,"Chocolates"),
        Item(4,"All"),
    )

}