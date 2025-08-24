package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.screen2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.passingplaincustomdataamongscreeninjetpackcompose.R
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.Color795548
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.ColorFFFFFF
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.cabinMediumFont
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp

@Composable
fun PlainDataScreen(
    plainData: String? = null,
    backArrowCallback: (() -> Unit)? = null
) {
    Scaffold(
        topBar = {
            MyToolbar(
                backArrowCallback = {
                    backArrowCallback?.invoke()
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) { Text(
                text = plainData ?: "Name: Nill\nAge: Nill",
                fontFamily = cabinMediumFont,
                fontWeight = FontWeight.Bold,
                color = Color795548,
                letterSpacing = 2.ssp,
                fontSize = 15.ssp,
                textAlign = TextAlign.Center,
                lineHeight = 25.ssp
            )
        }
    }
}

@Composable
fun MyToolbar(backArrowCallback: (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 50.sdp)
            .background(color = Color795548),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(start = 10.sdp)
                .clickable {
                    backArrowCallback?.invoke()
                },
            painter = painterResource(id = R.drawable.back_image),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = ColorFFFFFF)
        )
        Text(
            modifier = Modifier
                .padding(start = 10.sdp),
            text = stringResource(id = R.string.plain_data_text),
            color = ColorFFFFFF,
            fontWeight = FontWeight.Bold,
            fontFamily = cabinMediumFont,
            letterSpacing = 2.ssp
        )
    }
}