package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.navigations

import androidx.navigation.NavHostController
import com.example.passingplaincustomdataamongscreeninjetpackcompose.domain.models.Transfer

class NavigationActions(private val navHostController: NavHostController) {

    val goBack: () -> Unit = {
        navHostController.popBackStack()
    }

    val navigateToPlainDataScreen: (String) -> Unit = {
        navHostController.navigate(route = Routes.PlainDataScreenRoute(plainData = it))
    }

    val navigateToCustomDataScreen: (String) -> Unit = {
        navHostController.navigate(route = Routes.CustomDataScreenRoute(customData = it))
    }
}