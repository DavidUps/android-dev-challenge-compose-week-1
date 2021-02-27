package com.example.puppyadoption.features.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.example.puppyadoption.core.Constants.Companion.POPPY_DETAIL
import com.example.puppyadoption.core.Constants.Companion.POPPY_LIST


@Composable
fun PoppyList(navController: NavController) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate(POPPY_DETAIL) {
                popUpTo(route = POPPY_LIST) {}
            }
        },
    ) {
        Text(text = "Poppy List!")
    }


}