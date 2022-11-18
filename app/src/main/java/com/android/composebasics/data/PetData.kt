package com.android.composebasics.data

import com.android.composebasics.R

data class PetData(
    val id:Int,
    val name:String,
    val sex:String,
    val age:Int,
    val weight:Double,
    val imagePath:Int
)

var PetList = mutableListOf<PetData>(

PetData(0, "Bobby",  "Male", 9, 1.25, R.drawable.image_1),
PetData(1, "Bobby",  "Male", 9, 1.25, R.drawable.image_2),
PetData( 2, "Bobby",  "Male", 9, 1.25, R.drawable.image_3),
PetData( 3, "Bobby", "Male", 9, 1.25, R.drawable.image_4),
PetData(4, "Bobby", "Male", 9, 1.25, R.drawable.image_5),
PetData(5, "Bobby", "Male", 9, 1.25, R.drawable.image_6)
)
