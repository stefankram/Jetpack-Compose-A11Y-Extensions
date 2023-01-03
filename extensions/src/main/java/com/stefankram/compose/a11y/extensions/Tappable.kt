package com.stefankram.compose.a11y.extensions

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.gestures.PressGestureScope
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.debugInspectorInfo
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun Modifier.tappable(
    enabled: Boolean = true,
    onTap: () -> Unit,
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tappable"
        properties["enabled"] = enabled
        properties["onTap"] = onTap
    },
    factory = {
        Modifier.tappable(
            interactionSource = remember { MutableInteractionSource() },
            indication = LocalIndication.current,
            enabled = enabled,
            onTap = onTap
        )
    }
)

fun Modifier.tappable(
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    enabled: Boolean = true,
    onTap: () -> Unit,
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tappable"
        properties["enabled"] = enabled
        properties["onTap"] = onTap
        properties["indication"] = indication
        properties["interactionSource"] = interactionSource
    },
    factory = {
        val onTapState by rememberUpdatedState(onTap)
        val pressedInteraction = remember { mutableStateOf<PressInteraction.Press?>(null) }

        if (enabled) {
            PressedInteractionSourceDisposableEffect(interactionSource, pressedInteraction)
        }

        Modifier
            .indication(interactionSource, indication)
            .hoverable(enabled = enabled, interactionSource = interactionSource)
            .pointerInput(interactionSource, enabled) {
                detectTapGestures(
                    onPress = { offset ->
                        handlePressInteraction(
                            pressPoint = offset,
                            interactionSource = interactionSource,
                            pressedInteraction = pressedInteraction,
                        )
                    },
                    onTap = { if (enabled) onTapState.invoke() }
                )
            }
    }
)

@Composable
internal fun PressedInteractionSourceDisposableEffect(
    interactionSource: MutableInteractionSource,
    pressedInteraction: MutableState<PressInteraction.Press?>,
) {
    DisposableEffect(interactionSource) {
        onDispose {
            pressedInteraction.value?.let { oldValue ->
                val interaction = PressInteraction.Cancel(oldValue)
                interactionSource.tryEmit(interaction)
                pressedInteraction.value = null
            }
        }
    }
}

internal suspend fun PressGestureScope.handlePressInteraction(
    pressPoint: Offset,
    interactionSource: MutableInteractionSource,
    pressedInteraction: MutableState<PressInteraction.Press?>,
) {
    coroutineScope {
        val delayJob = launch {
            val pressInteraction = PressInteraction.Press(pressPoint)
            interactionSource.emit(pressInteraction)
            pressedInteraction.value = pressInteraction
        }
        val success = tryAwaitRelease()
        if (delayJob.isActive) {
            delayJob.cancelAndJoin()
            // The press released successfully, before the timeout duration - emit the press
            // interaction instantly. No else branch - if the press was cancelled before the
            // timeout, we don't want to emit a press interaction.
            if (success) {
                val pressInteraction = PressInteraction.Press(pressPoint)
                val releaseInteraction = PressInteraction.Release(pressInteraction)
                interactionSource.emit(pressInteraction)
                interactionSource.emit(releaseInteraction)
            }
        } else {
            pressedInteraction.value?.let { pressInteraction ->
                val endInteraction = if (success) {
                    PressInteraction.Release(pressInteraction)
                } else {
                    PressInteraction.Cancel(pressInteraction)
                }
                interactionSource.emit(endInteraction)
            }
        }
        pressedInteraction.value = null
    }
}
