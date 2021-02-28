package com.davidups.puppy_adoption.core

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.puppyadoption.core.theme.PuppyAdoptionTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionTheme {
                InitNavigation()
            }
        }
    }
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Composable
private fun InitNavigation() {
    Surface {
        NavGraph()
    }
}

@ExperimentalStdlibApi
@ExperimentalFoundationApi
@Preview("App")
@Composable
private fun App() {
    PuppyAdoptionTheme {
        InitNavigation()
    }
}