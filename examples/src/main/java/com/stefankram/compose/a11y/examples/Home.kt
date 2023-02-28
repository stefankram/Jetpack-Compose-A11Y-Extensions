package com.stefankram.compose.a11y.examples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stefankram.compose.a11y.examples.components.RoundedButton
import com.stefankram.compose.a11y.examples.theme.Theme

@Composable
internal fun Home(
    onNavigateToClickableButtonExamples: () -> Unit,
    onNavigateToOptionableExamples: () -> Unit,
    onNavigateToOptionableGroupExamples: () -> Unit,
    onNavigateToTappableExamples: () -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        RoundedButton(
            text = stringResource(id = R.string.examples_home_clickable_button_cta),
            onClick = onNavigateToClickableButtonExamples,
            colors = ButtonDefaults.outlinedButtonColors()
        )

        RoundedButton(
            text = stringResource(id = R.string.examples_home_optionable_cta),
            onClick = onNavigateToOptionableExamples,
            colors = ButtonDefaults.outlinedButtonColors(),
        )

        RoundedButton(
            text = stringResource(id = R.string.examples_home_optionable_group_cta),
            onClick = onNavigateToOptionableGroupExamples,
            colors = ButtonDefaults.outlinedButtonColors(),
        )

        RoundedButton(
            text = stringResource(id = R.string.examples_home_tappable_cta),
            onClick = onNavigateToTappableExamples,
            colors = ButtonDefaults.outlinedButtonColors(),
        )
    }
}

@Preview
@Composable
private fun HomePreview() {
    Theme {
        Home(
            onNavigateToClickableButtonExamples = {},
            onNavigateToOptionableExamples = {},
            onNavigateToOptionableGroupExamples = {},
            onNavigateToTappableExamples = {},
        )
    }
}
