package com.davidups.puppy_adoption.core

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.puppyadoption.core.Constants.Companion.POPPY_DETAIL
import com.example.puppyadoption.core.Constants.Companion.POPPY_LIST
import com.example.puppyadoption.features.ui.screens.PoppyDetail
import com.example.puppyadoption.features.ui.screens.PoppyList

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = POPPY_LIST) {
        composable(POPPY_LIST) {
            PoppyList(navController)
        }
        composable(POPPY_DETAIL) {
            PoppyDetail(navController)
        }
    }
}
