/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.davidups.puppy_adoption.features.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davidups.puppy_adoption.features.ui.components.PuppiesListItem
import com.davidups.puppy_adoption.features.ui.components.SearchTopBar
import com.davidups.puppy_adoption.features.ui.models.Puppy

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Composable
fun PuppyList(navController: NavController) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background),
    ) {
        SearchTopBar()
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(24.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(Puppy.generate()) { index, item ->
                key(index) {
                    PuppiesListItem(navController = navController, item = item, index = index)
                }
            }
        }
    }
}
