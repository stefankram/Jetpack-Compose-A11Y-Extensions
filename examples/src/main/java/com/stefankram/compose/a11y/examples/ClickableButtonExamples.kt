package com.stefankram.compose.a11y.examples

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

@Composable
internal fun ClickableButtonExamples() {
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Box(
            modifier = Modifier
                .clip(Theme.shapes.medium)
                .background(Theme.colors.primary, Theme.shapes.medium)
                .clickableButton { context.showToast("Clicked!") }
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
                .background(Theme.colors.primary, Theme.shapes.medium)
                .combinedClickableButton(
                    onLongClick = { context.showToast("Long clicked!") },
                    onDoubleClick = { context.showToast("Double clicked!") },
                    onClick = { context.showToast("Clicked!") }
                )
                .padding(12.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                color = Theme.colors.onPrimary,
                text = "Combined Clickable"
            )
        }
    }
}

@Preview
@Composable
private fun ClickableButtonExamplePreview() {
    Theme {
        ClickableButtonExamples()
    }
}
