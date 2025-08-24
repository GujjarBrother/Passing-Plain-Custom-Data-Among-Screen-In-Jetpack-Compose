package com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.navigations

import com.example.passingplaincustomdataamongscreeninjetpackcompose.domain.models.Transfer
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object ScreenARoute : Routes()

    @Serializable
    data class PlainDataScreenRoute(val plainData: String) : Routes()

    @Serializable
    data class CustomDataScreenRoute(val customData: String? = null) : Routes()
}