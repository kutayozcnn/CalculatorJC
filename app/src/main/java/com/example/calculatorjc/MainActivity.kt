package com.example.calculatorjc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorjc.ui.theme.CalculatorJCTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJCTheme {
            }
        }
    }
}




@Composable
fun Calculator() {
    val mContext = LocalContext.current
    var result by remember { mutableStateOf(0.0) }
    var num2 by remember { mutableStateOf("") }
    var num1 by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(androidx.compose.ui.graphics.Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.spacedBy(5.dp,Alignment.CenterVertically),
        ) {
            TextField(value = num1
                , onValueChange = {value ->
                    if (value.length <= 2) {
                        num1 = value.filter { it.isDigit() }}}
                ,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            TextField(value = num2
                , onValueChange = {value ->
                    if (value.length <= 2) {
                        num2 = value.filter { it.isDigit() }}}
                ,keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp,Alignment.CenterHorizontally)
            ) {
                Button(onClick = {
                    if (num1 == null || num2 == null ) {
                        Toast.makeText(mContext,"Lütfen Değer Giriniz",Toast.LENGTH_LONG)
                } else {
                        result = (num1?.toDoubleOrNull()).sum(num2?.toDoubleOrNull())
                        Toast.makeText(mContext,"Lütfen Değer Giriniz",Toast.LENGTH_LONG)
                }  }) {
                    Text(text = "+")

                }
                Button(onClick = {
                    if (num1 == null || num2 == null ) {
                        Toast.makeText(mContext,"Lütfen Değer Giriniz",Toast.LENGTH_LONG)
                } else {
                        result = (num1?.toDoubleOrNull()).sub(num2?.toDoubleOrNull())

                }  }) {
                    Text(text = "-")

                }
                Button(onClick = {
                    if (num1 == null || num2 == null ) {
                        Toast.makeText(mContext,"Lütfen Değer Giriniz",Toast.LENGTH_LONG)
                } else {
                        result = (num1?.toDoubleOrNull()).divide(num2?.toDoubleOrNull())

                }
                }) {
                    Text(text = "/")

                }
                Button(onClick = {
                    if (num1 == null || num2 == null ) {
                        Toast.makeText(mContext,"Lütfen Değer Giriniz",Toast.LENGTH_LONG)
                } else {
                        result = (num1?.toDoubleOrNull()).multy(num2?.toDoubleOrNull())

                }  }) {
                    Text(text = "*")
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text ="Result = ${result}"
                    ,modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(5.dp)
                    , fontSize = 25.sp
                )
            }

            }
        }
    }

private fun Double?.multy(num2: Double?): Double {
return this!! * num2!!
}

private fun Double?.divide(num2: Double?): Double {
    return this!! / num2!!
}

private fun Double?.sub(num2: Double?): Double {
    return this!! - num2!!
}

private fun Double?.sum(num2: Double?): Double {
    return this!! + num2!!
}


@Preview
@Composable
fun Screen() {
    Calculator()
}