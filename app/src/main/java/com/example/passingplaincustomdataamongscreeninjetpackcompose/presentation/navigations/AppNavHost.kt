package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.passingplaincustomdataamongscreeninjetpackcompose.domain.models.Transfer
import com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.customDataScreen.CustomDataScreen
import com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.screen1.ScreenA
import com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.screen2.PlainDataScreen
import com.google.gson.Gson

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    val navigationActions = NavigationActions(navHostController)

    NavHost(
        navController = navHostController, startDestination = Routes.ScreenARoute
    ) {
        composable<Routes.ScreenARoute> {
            ScreenA(
                passPlainDataCallback = {
                   navigationActions.navigateToPlainDataScreen.invoke(it)
                },
                passCustomDataCallback = {
                    navigationActions.navigateToCustomDataScreen.invoke(it)
                }
            )
        }

        composable<Routes.PlainDataScreenRoute> {
            val plainDataScreenRoute: Routes.PlainDataScreenRoute = it.toRoute()
            PlainDataScreen(
                plainData = plainDataScreenRoute.plainData,
                backArrowCallback = {
                    navigationActions.goBack.invoke()
                }
            )
        }

        composable<Routes.CustomDataScreenRoute> {
            val customDataScreenRoute: Routes.CustomDataScreenRoute = it.toRoute()
            val transfer = Gson().fromJson(customDataScreenRoute.customData, Transfer::class.java)
            CustomDataScreen(
                transfer = transfer,
                backArrowCallback = {
                    navigationActions.goBack.invoke()
                }
            )
        }
    }
}