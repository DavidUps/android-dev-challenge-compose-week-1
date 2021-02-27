package com.davidups.puppy_adoption.core

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.davidups.puppy_adoption.features.ui.screens.PuppyDetail
import com.davidups.puppy_adoption.core.Constants.Companion.PUPPY_DETAIL
import com.davidups.puppy_adoption.core.Constants.Companion.PUPPY_LIST
import com.davidups.puppy_adoption.features.ui.screens.PuppyList

@ExperimentalFoundationApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = PUPPY_LIST) {
        composable(PUPPY_LIST) {
            PuppyList(navController)
        }
        composable(PUPPY_DETAIL) {
            PuppyDetail(navController)
        }
    }
}
