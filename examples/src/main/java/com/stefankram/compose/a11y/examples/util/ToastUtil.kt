package com.stefankram.compose.a11y.examples.util

import android.content.Context
import android.widget.Toast

internal fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast
        .makeText(this, message, length)
        .show()
}
