package com.stefankram.compose.a11y.examples

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stefankram.compose.a11y.examples.theme.Theme
import com.stefankram.compose.a11y.examples.util.showToast
import com.stefankram.compose.a11y.extensions.clickableButton
import com.stefankram.compose.a11y.extensions.combinedClickableButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ClickableButtonExample() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(Theme.shapes.medium)
                .background(Theme.colors.primary, Theme.shapes.medium)
                .clickableButton { showToast(context, "Clicked!") }
                .padding(12.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                color = Theme.colors.onPrimary,
                text = "Clickable"
            )
        }

        Box(
            modifier = Modifier
                .clip(Theme.shapes.medium)
                .background(Theme.colors.secondary, Theme.shapes.medium)
                .combinedClickableButton(
                    onLongClick = { showToast(context, "Long clicked!") },
                    onDoubleClick = { showToast(context, "Double clicked!") },
                    onClick = { showToast(context, "Clicked!") }
                )
                .padding(12.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                color = Theme.colors.onSecondary,
                text = "Combined Clickable"
            )
        }
    }
}

@Preview
@Composable
fun ClickableButtonExamplePreview() {
    Theme {
        ClickableButtonExample()
    }
}
