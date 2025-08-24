package com.example.passingplaincustomdataamongscreeninjetpackcompose.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Transfer(
    val name: String? = null,
    val age: String? = null
)
