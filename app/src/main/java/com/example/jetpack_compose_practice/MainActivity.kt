package com.example.jetpack_compose_practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_practice.component.InputField
import com.example.jetpack_compose_practice.ui.theme.DefaultTheme
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.example.jetpack_compose_practice.widget.RoundIconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // enter point for emulator // not preview
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DefaultTheme {
                MyApp {
                    Text("Hello Again!!")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DefaultTheme {
        MyApp {
            MainContent()
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopHeader()

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            MainContent()
        }
    }
}

@Composable
fun TopHeader(totalPerPerson: Double = 134.0) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp)))
        ,
        // .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))
        color = Color(color = 0xFFE9D7f7)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val total = "%.2f".format(totalPerPerson) // for format
            Text(text = "Total Per Person",
                style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "$$total",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun MainContent() {
    BillForm() {
        billAmt ->
        Log.d("AMT", "MainContent: ${billAmt.toInt() * 100}")
    }
}

@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValChange: (String) -> Unit,
    ) {
    val totalBillState = remember {
        mutableStateOf("")
    }

    val validState = remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()
    } // check validations

    val keyboardController = LocalSoftwareKeyboardController.current

    val splitNumber = remember {
        mutableStateOf(0)
    }

    val sliderPositionState = remember {
        mutableStateOf(
            0f
        )
    }

    Surface(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth()
        .fillMaxHeight()
        .height(150.dp),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 3.dp, color = Color.LightGray),
        color = Color(color = 0xFFFFFFFF)
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            InputField(
                valueState = totalBillState,
                labelId = "Enter bill",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    // Todo - gnvaluechanged
                    onValChange(totalBillState.value.trim())
                    keyboardController?.hide()
                    // close the keyboard
                }
            )

            if (validState) {
                Row(modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start)
                {
                    Text(
                        text = "Split",
                        modifier = Modifier.align(
                            alignment = Alignment.CenterVertically
                        )
                    )
                    Spacer(modifier = Modifier.width(120.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RoundIconButton(
                            imageVector = Icons.Default.Remove,
                            onClick = {
                                if (splitNumber.value > 0) splitNumber.value -= 1
                            }
                        )
                        Text(
                            text = splitNumber.value.toString()
                        )
                        RoundIconButton(
                            imageVector = Icons.Default.Add,
                            onClick = {
                                splitNumber.value += 1
                            }
                        )
                    }
                }

                Row() {
                    Text(
                        text = "Tip",
                        modifier = Modifier.align(alignment =  Alignment.CenterVertically)
                        )
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(
                        text = "$33.00",
                        )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "${sliderPositionState.value}")

                    Spacer(modifier = Modifier.height(14.dp))

                    // Slider
                    Slider(
                        value = sliderPositionState.value,
                        onValueChange = { newVal ->
                            sliderPositionState.value = newVal
                        }
                    )
                }


            } else {
                Box() {}
            }
        }
    }
}