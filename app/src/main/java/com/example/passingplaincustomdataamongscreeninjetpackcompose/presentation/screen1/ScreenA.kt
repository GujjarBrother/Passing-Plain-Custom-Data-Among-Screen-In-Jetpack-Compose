package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.screen1

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.example.passingplaincustomdataamongscreeninjetpackcompose.R
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.Color000000
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.Color795548
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.ColorFFFFFF
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.cabinMediumFont
import com.example.passingplaincustomdataamongscreeninjetpackcompose.domain.models.Transfer
import com.google.gson.Gson
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp
import org.koin.androidx.compose.koinViewModel

@SuppressLint("CheckResult")
@Composable
fun ScreenA(
    viewModel: ScreenAViewModel = koinViewModel(),
    passPlainDataCallback: ((String) -> Unit)? = null,
    passCustomDataCallback: ((String) -> Unit)? = null
) {
    val state = viewModel.state.collectAsState().value
    val softwareKeyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = {
            MyToolbar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .background(color = ColorFFFFFF),
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.sdp),
                value = state.name ?: "",
                onValueChange = {
                    viewModel.updateName(name = it)
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_name_text),
                        fontFamily = cabinMediumFont
                    )
                },
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = cabinMediumFont,
                    fontWeight = FontWeight.Bold
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = ColorFFFFFF,
                    focusedContainerColor = ColorFFFFFF,
                    unfocusedIndicatorColor = Color000000,
                    focusedIndicatorColor = Color795548,
                    cursorColor = Color795548
                )
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.sdp),
                value = state.age ?: "",
                onValueChange = {
                    viewModel.updateAge(age = it)
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_age_text),
                        fontFamily = cabinMediumFont
                    )
                },
                singleLine = true,
                textStyle = TextStyle(
                    fontFamily = cabinMediumFont,
                    fontWeight = FontWeight.Bold
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Go
                ),
                keyboardActions = KeyboardActions(
                    onGo = {
                        softwareKeyboardController?.hide()
                    }
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = ColorFFFFFF,
                    focusedContainerColor = ColorFFFFFF,
                    unfocusedIndicatorColor = Color000000,
                    focusedIndicatorColor = Color795548,
                    cursorColor = Color795548
                )
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.sdp, top = 10.sdp, end = 10.sdp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color795548
                ),
                onClick = {
                    if (state.name?.isNotEmpty() == true && state.age?.isNotEmpty() == true) {
                        passPlainDataCallback?.invoke(
                            "${state.name}\n${state.age}"
                        )
                    }
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.sdp),
                    text = stringResource(id = R.string.pass_plain_text_text),
                    fontFamily = cabinMediumFont,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.ssp
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.sdp, top = 10.sdp, end = 10.sdp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color795548
                ),
                onClick = {
                    if (state.name?.isNotEmpty() == true && state.age?.isNotEmpty() == true) {
                        val transfer = Transfer(state.name, state.age)
                        passCustomDataCallback?.invoke(Gson().toJson(transfer))
                    }
                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.sdp),
                    text = stringResource(id = R.string.pass_custom_data_text),
                    fontFamily = cabinMediumFont,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.ssp
                )
            }
        }
    }
}

@Composable
fun MyToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 50.sdp)
            .background(color = Color795548),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.sdp),
            text = stringResource(id = R.string.passing_plain_custom_data_text),
            color = ColorFFFFFF,
            fontWeight = FontWeight.Bold,
            fontFamily = cabinMediumFont,
            letterSpacing = 2.ssp
        )
    }
}