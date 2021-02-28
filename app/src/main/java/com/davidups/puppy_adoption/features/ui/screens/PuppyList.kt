package com.davidups.puppy_adoption.features.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.davidups.puppy_adoption.core.Constants
import com.davidups.puppy_adoption.core.Constants.Companion.PUPPY_DETAIL
import com.davidups.puppy_adoption.core.theme.Purple700
import com.davidups.puppy_adoption.core.theme.White
import com.davidups.puppy_adoption.features.ui.models.Puppy
import com.davidups.puppy_adoption.core.Constants.Companion.PUPPY_LIST
import com.davidups.puppy_adoption.core.theme.Shapes
import dev.chrisbanes.accompanist.coil.CoilImage

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

@Composable
private fun SearchTopBar() {
    var editTextSearch by remember { mutableStateOf(TextFieldValue("")) }
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
                navController.navigate("puppy_detail/${index.toString()}") {
                    popUpTo(route = PUPPY_LIST) {}
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
                        style = typography.body1,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = item.gender.name.uppercase().capitalize(),
                        style = typography.overline
                    )
                    Text(text = item.age.toString(), style = typography.overline)
                }
            }
        }
    }
}