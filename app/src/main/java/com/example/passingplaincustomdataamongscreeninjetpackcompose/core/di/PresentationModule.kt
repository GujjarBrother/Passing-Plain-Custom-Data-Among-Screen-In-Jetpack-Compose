package com.example.passingplaincustomdataamongscreeninjetpackcompose.core.di

import com.example.passingplaincustomdataamongscreeninjetpackcompose.presentation.screen1.ScreenAViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::ScreenAViewModel)
}