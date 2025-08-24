package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.Color795548
import com.example.passingplaincustomdataamongscreeninjetpackcompose.core.utils.PassingPlainCustomDataAmongScreenInJetpackComposeTheme
import com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.navigations.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color795548.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(Color795548.toArgb())
        )
        setContent {
            PassingPlainCustomDataAmongScreenInJetpackComposeTheme {
                val navHostController = rememberNavController()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.systemBars.asPaddingValues())
                ) {
                    AppNavHost(navHostController = navHostController)
                }
            }
        }
    }
}