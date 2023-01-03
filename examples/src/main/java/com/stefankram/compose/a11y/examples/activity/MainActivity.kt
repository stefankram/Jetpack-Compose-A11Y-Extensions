package com.stefankram.compose.a11y.examples.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.stefankram.compose.a11y.examples.ClickableButtonExample
import com.stefankram.compose.a11y.examples.CollectionInfoExample
import com.stefankram.compose.a11y.examples.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                Column {
                    ClickableButtonExample()
                    CollectionInfoExample()
                }
            }
        }
    }
}
