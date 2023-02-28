package com.stefankram.compose.a11y.examples.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stefankram.compose.a11y.examples.ClickableButtonExamples
import com.stefankram.compose.a11y.examples.Home
import com.stefankram.compose.a11y.examples.OptionableExamples
import com.stefankram.compose.a11y.examples.OptionableGroupExamples
import com.stefankram.compose.a11y.examples.R
import com.stefankram.compose.a11y.examples.TappableExamples
import com.stefankram.compose.a11y.examples.theme.Theme

private enum class Routes(
    val route: String,
    @StringRes val title: Int,
) {
    HOME(
        route = "home",
        title = R.string.examples_nav_host_home_route_title,
    ),
    CLICKABLE_BUTTON_EXAMPLES(
        route = "clickableButtonExample",
        title = R.string.examples_nav_host_clickable_button_examples_route_title,
    ),
    OPTIONABLE_EXAMPLES(
        route = "optionableExample",
        title = R.string.examples_nav_host_optionable_examples_route_title,
    ),
    OPTIONABLE_GROUP_EXAMPLES(
        route = "optionableGroupExample",
        title = R.string.examples_nav_host_optionable_group_examples_route_title,
    ),
    TAPPABLE_EXAMPLES(
        route = "tappableExample",
        title = R.string.examples_nav_host_tappable_examples_route_title,
    ),
}

@Composable
internal fun MainNavHost() {
    val navController = rememberNavController()
    var topBarTitle by remember { mutableStateOf(Routes.HOME.title) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = topBarTitle)) },
            )
        }
    ) { padding ->
        NavHost(
            modifier = Modifier
                .padding(padding)
                .padding(12.dp),
            navController = navController,
            startDestination = Routes.HOME.route,
        ) {
            Routes.HOME.run {
                composable(route) {
                    topBarTitle = title
                    Home(
                        onNavigateToClickableButtonExamples = {
                            navController.navigate(Routes.CLICKABLE_BUTTON_EXAMPLES.route)
                        },
                        onNavigateToOptionableExamples = {
                            navController.navigate(Routes.OPTIONABLE_EXAMPLES.route)
                        },
                        onNavigateToOptionableGroupExamples = {
                            navController.navigate(Routes.OPTIONABLE_GROUP_EXAMPLES.route)
                        },
                        onNavigateToTappableExamples = {
                            navController.navigate(Routes.TAPPABLE_EXAMPLES.route)
                        },
                    )
                }
            }

            Routes.CLICKABLE_BUTTON_EXAMPLES.run {
                composable(route) {
                    topBarTitle = title
                    ClickableButtonExamples()
                }
            }

            Routes.OPTIONABLE_EXAMPLES.run {
                composable(route) {
                    topBarTitle = title
                    OptionableExamples()
                }
            }

            Routes.OPTIONABLE_GROUP_EXAMPLES.run {
                composable(route) {
                    topBarTitle = title
                    OptionableGroupExamples()
                }
            }

            Routes.TAPPABLE_EXAMPLES.run {
                composable(route) {
                    topBarTitle = title
                    TappableExamples()
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainNavHostPreview() {
    Theme {
        MainNavHost()
    }
}
