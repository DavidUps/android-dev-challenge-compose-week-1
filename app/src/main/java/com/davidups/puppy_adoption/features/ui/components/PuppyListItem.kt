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
package com.davidups.puppy_adoption.features.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.davidups.puppy_adoption.core.Constants
import com.davidups.puppy_adoption.core.theme.Shapes
import com.davidups.puppy_adoption.core.theme.White
import com.davidups.puppy_adoption.features.ui.models.Puppy
import dev.chrisbanes.accompanist.coil.CoilImage

@ExperimentalStdlibApi
@Composable
fun PuppiesListItem(navController: NavController, item: Puppy, index: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy((-15).dp),
            modifier = Modifier.clickable {
                navController.navigate("puppy_detail/$index") {
                    popUpTo(route = Constants.PUPPY_LIST) {}
                }
            },
        ) {
            Card(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            ) {
                CoilImage(
                    data = item.photo,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    fadeIn = true,
                    loading = {
                        Box(Modifier.matchParentSize()) {
                            CircularProgressIndicator(Modifier.align(Alignment.Center))
                        }
                    },
                    error = { error ->
                        Log.w("PuppyAvatar", error.throwable)
                    }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = White, shape = Shapes.large)
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = item.gender.name.uppercase(),
                        style = MaterialTheme.typography.overline
                    )
                    Text(text = item.age.toString(), style = MaterialTheme.typography.overline)
                }
            }
        }
    }
}
