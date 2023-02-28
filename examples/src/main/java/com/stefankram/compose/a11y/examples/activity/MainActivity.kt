package com.stefankram.compose.a11y.examples.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stefankram.compose.a11y.examples.navigation.MainNavHost
import com.stefankram.compose.a11y.examples.theme.Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme {
                MainNavHost()
            }
        }
    }
}
