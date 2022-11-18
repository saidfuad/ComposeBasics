package com.android.composebasics.ui.screen



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.composebasics.R
import com.android.composebasics.data.PetData
import com.android.composebasics.data.PetList

@Composable
fun HomeScreen(navController: NavHostController) {
   // Text(text = "Hello, Compose")
    Scaffold {
       Box(modifier = Modifier
           .background(Color.Blue)
           .padding(24.dp)
           .fillMaxSize()
       ){
           LazyColumn(){
               //this is equivalent of recyleview
               item{
                   Header()
                   Spacer(modifier = Modifier.height(24.dp))
                   SearchField()
                   Spacer(modifier = Modifier.height(32.dp))
                   Text(text = "New Pets", style= TextStyle(color = Color.White, fontWeight = FontWeight.Bold))
                   Spacer(modifier = Modifier.height(32.dp))
               }
               items(PetList.size){
                   item -> PetListItem(item = PetList[item], onCardClick ={
                      // Navigation Function and Argument
                    item ->navController.navigate("details/${item.id}")
               })
               }
           }
       }

    }
}


@Composable
fun Header(name: String = "My First Jetpack app"){
Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth()

){
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "Greetings, $name",
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
            )

        Text(text = "Lets find what you need",
            style = MaterialTheme.typography.body1,
            color = Color.White
        )
        }
    //icon
   Icon(

       painter = painterResource(id =R.drawable.ic_baseline_pets_24) ,
       contentDescription = "an icon",
        tint = Color.White,
       modifier = Modifier
           .size(32.dp)
           .rotate(-45.0f)
   )

    }
}

@Composable
fun SearchField(){
    val textFieldValue = remember { mutableStateOf("")}
    TextField(
        value = textFieldValue.value,
        onValueChange = {value -> textFieldValue.value = value},

        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 24.sp,
            color = Color.White,
        ),
        maxLines =1,
        placeholder = {
            Text(
                text ="Type a Pet Name",
                color = Color.White,

            )
        },
        leadingIcon ={
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = "Search Button",
                tint = Color.White,
            )
        },

        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = Color.White,
        )
    )
}

@Composable
fun PetListItem(item:PetData, onCardClick :(PetData) -> Unit){
    Card(backgroundColor = Color.LightGray,
    modifier = Modifier
        .padding(bottom = 16.dp)
        .clip(RoundedCornerShape(size = 8.dp))
        .background(Color.LightGray)
        .clickable(onClick = { onCardClick(item) }, enabled = true)
        .padding(12.dp),
        elevation = 0.dp
        ) {
        Column(Modifier.padding(8.dp)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(color = Color.Gray),
            Alignment.Center
            ){
                Image(painter = painterResource(id = item.imagePath), contentDescription =null, contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize())
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(item.name, style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp))
            PetDetails(age = item.age, weight = item.weight)

        }
    }

}

@Composable
fun PetDetails(age:Int, weight: Double){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Column(
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ){
            val year = if(age>1) "Years" else "Year"
            Text( "Age", style = TextStyle(
                color = Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
                textAlign = TextAlign.Center
            )
            Text(text = "$age, $year", textAlign = TextAlign.Center, color = Color(0xFFdfdfdf))
        }
        Column(
            Modifier
                .weight(1F)
                .align(Alignment.CenterVertically)
        ){
            val year = if(age>1) "Years" else "Year"
            Text( "Weight", style = TextStyle(
                color = Color(0xaaFFFFFF),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            ),
                textAlign = TextAlign.Center
            )
            Text(text = "$weight Kg", textAlign = TextAlign.Center, color = Color(0xFFdfdfdf))
        }
    }
}