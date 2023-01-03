package com.stefankram.compose.a11y.extensions

import androidx.compose.foundation.Indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role

fun Modifier.optionable(
    role: Role,
    selected: Boolean,
    enabled: Boolean = true,
    onClick: (Boolean) -> Unit,
): Modifier = when (role) {
    Role.RadioButton, Role.Tab -> this.selectable(
        selected = selected,
        enabled = enabled,
        role = role,
        onClick = { onClick(!selected) }
    )
    Role.Checkbox, Role.Switch -> this.toggleable(
        value = selected,
        enabled = enabled,
        role = role,
        onValueChange = onClick
    )
    else -> throw IllegalArgumentException("$role role is not supported")
}

fun Modifier.optionable(
    role: Role,
    selected: Boolean,
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    enabled: Boolean = true,
    onClick: (Boolean) -> Unit
): Modifier = when (role) {
    Role.RadioButton, Role.Tab -> this.selectable(
        selected = selected,
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        role = role,
        onClick = { onClick(!selected) }
    )
    Role.Checkbox, Role.Switch -> this.toggleable(
        value = selected,
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        role = role,
        onValueChange = onClick
    )
    else -> throw IllegalArgumentException("$role role is not supported")
}
