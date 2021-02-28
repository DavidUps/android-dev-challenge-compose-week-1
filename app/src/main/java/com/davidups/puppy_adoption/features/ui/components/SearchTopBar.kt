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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.davidups.puppy_adoption.core.theme.Purple700
import com.davidups.puppy_adoption.core.theme.White

@Composable
fun SearchTopBar() {
    var editTextSearch: String by mutableStateOf("")
    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 5.dp,
            shape = RoundedCornerShape(
                topEnd = 0.dp,
                topStart = 0.dp,
                bottomEnd = 24.dp,
                bottomStart = 24.dp
            ),
            backgroundColor = Purple700
        ) {
            Row(
                modifier = Modifier.padding(start = 32.dp, end = 32.dp, bottom = 32.dp, top = 8.dp),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    backgroundColor = White
                ) {
                    TextField(
                        value = editTextSearch,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        label = { Text(text = "Search") },
                        onValueChange = { editTextSearch = it }
                    )
                }
            }
        }
    }
}
