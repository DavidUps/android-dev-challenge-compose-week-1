package com.davidups.puppy_adoption.features.ui.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davidups.puppy_adoption.core.theme.Shapes
import com.davidups.puppy_adoption.core.theme.White
import com.davidups.puppy_adoption.features.ui.models.Puppy
import com.google.android.material.button.MaterialButton
import dev.chrisbanes.accompanist.coil.CoilImage

@ExperimentalStdlibApi
@Composable
fun PuppyDetail(navController: NavController, puppyPosition: String) {
    val puppy = Puppy.generate()[puppyPosition.toInt()]
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
    ) {
        Card(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        ) {
            CoilImage(
                data = puppy.photo,
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
                    text = puppy.name,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = puppy.gender.name.uppercase().capitalize(),
                    style = MaterialTheme.typography.overline
                )
                Text(text = puppy.age.toString(), style = MaterialTheme.typography.overline)
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            val context = LocalContext.current
            Button(
                onClick = {
                    navController.navigateUp()
                    Toast.makeText(context, "Adopted", Toast.LENGTH_SHORT).show()
                },
            ) {
                Text(text = "Adoption")
            }
        }

    }
}