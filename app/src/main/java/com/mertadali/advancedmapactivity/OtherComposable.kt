package com.mertadali.advancedmapactivity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mertadali.advancedmapactivity.ui.theme.Shapes

@Composable
fun OtherScreen() {

    // Column(sütun) ->    Vertical Arrangement(Dikey düzenleme) , Horizontal Alignment(Yatay hizalama)
    // Row(satır)    ->    HorizontalArrangement(Yatay düzenleme) , Vertical  Alignment(Dikey hizalama)
    // Box

    Column(modifier = Modifier
        .fillMaxSize(1f)
        .clickable {
            println("DENEME")
        }
        .background(color = Color.LightGray)
        .padding(top = 40.dp)
        , verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {

        CustomText(text = "Mert Adalı")
        Spacer(modifier = Modifier.padding(5.dp))          // Textler arasına boşluk koymak için.
        CustomText(text = "Miray Canbazoğlu")
        Spacer(modifier = Modifier.padding(10.dp))



        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 10.dp)
                .padding(top = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Surface(color = Color.Gray) {
                Column(modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(5.dp),
                    verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {


                    /*   STATE MANAGEMENT İŞLEMLERİ
                         EditText = TextField şeklinde yapılacak.
                         -> kullanıcı EditText değişikliklerini göremiyor
                         -> kullanıcı butona bastığında text değişmiyor  bu sorunlar için state management kavramı devreye giriyor.


                        var myText = "Hello"

                       TextField(value = TextFieldValue(myText) , onValueChange = {
                           myText = it.text

                       } )

                      */

                    // STATE MANAGEMENT İLE YUKARIDAKİ PROBLEM ÇÖZÜMÜ


                    var myString = remember {
                        mutableStateOf(value = "Hello")
                    }

                    var myTextString = remember {
                        mutableStateOf(value = "Deneme")
                    }

                    TextField(value = myTextString.value, onValueChange ={
                        myTextString.value = it
                    } )


                    Row (modifier = Modifier.fillMaxWidth(1f),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically){

                        CustomText(text = myString.value)
                        Spacer(modifier = Modifier.padding(5.dp))
                        CustomText(text = "Miray")

                        Spacer(modifier = Modifier.padding(10.dp))

                    }







                    Button(onClick = { myString.value = "Mert" },
                        shape = Shapes.medium,
                        border = BorderStroke(10.dp, color = Color.Blue)
                    ) {
                        Text(text = "Sign In")


                    }
                    Spacer(modifier = Modifier.padding(7.dp))

                    Image(bitmap = ImageBitmap.imageResource(id = R.drawable.kapak1) , contentDescription = "kapak" )

                    Spacer(modifier = Modifier.padding(7.dp))

                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background), contentDescription = null )
                }

            }


        }

    }


}

@Composable
fun CustomText(text: String){
    Text(modifier = Modifier
        .background(color = Color.DarkGray)
        .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
        // .fillMaxWidth(1f)
        .width(150.dp)
        ,text = text,
        color = Color.LightGray,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )


}