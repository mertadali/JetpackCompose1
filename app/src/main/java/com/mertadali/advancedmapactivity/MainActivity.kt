package com.mertadali.advancedmapactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Composable için son paratmetre olarak verilmiş bunu setContent içine parametre olarak vermiyoruz. Bunun için lambda expression var.
       setContent {
         MainScreen()
                                                                             // Greeting -> Selamlama demek
       }
    }
}
@Composable
fun MainScreen(){

// STATE HOSTİNG işlemi : tekrardan kullanacağımız bir compose hatalara sebep olabilir.
    var myString = remember{ mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize(1f)) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SpecialText(string = "MERT")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialText(string = "MİRAY")
            Spacer(modifier = Modifier.padding(5.dp))

            SpecialTextField(string = myString.value){
                myString.value = it
            }



        }


    }

}
@Composable
fun SpecialText(string: String){
    Text(text = string,
         fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.SansSerif
    )

}
@Composable
fun SpecialTextField(string: String, function : (String) -> Unit){

    TextField(value = string, onValueChange = function, Modifier.padding(5.dp))
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   MainScreen()
}