package com.stefankram.compose.a11y.examples.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = {
            Box(modifier = Modifier.background(Theme.colors.background)) {
                content()
            }
        }
    )
}

val Theme: MaterialTheme = MaterialTheme
