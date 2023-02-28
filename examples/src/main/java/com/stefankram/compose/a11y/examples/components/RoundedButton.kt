package com.stefankram.compose.a11y.examples.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stefankram.compose.a11y.examples.theme.Theme

@Composable
internal fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        shape = Theme.shapes.medium,
        colors = colors,
        contentPadding = PaddingValues(12.dp),
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun RoundedButtonPreview() {
    Theme {
        RoundedButton(text = "Preview", onClick = {})
    }
}
