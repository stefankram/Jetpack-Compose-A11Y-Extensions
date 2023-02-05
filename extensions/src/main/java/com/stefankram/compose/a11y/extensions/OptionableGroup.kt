package com.stefankram.compose.a11y.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.CollectionInfo
import androidx.compose.ui.semantics.CollectionItemInfo
import androidx.compose.ui.semantics.collectionInfo
import androidx.compose.ui.semantics.collectionItemInfo
import androidx.compose.ui.semantics.semantics

fun Modifier.optionableGroup(size: Int, isColumn: Boolean = true): Modifier = this.semantics {
    collectionInfo = if (isColumn) {
        CollectionInfo(
            rowCount = size,
            columnCount = 1
        )
    } else {
        CollectionInfo(
            rowCount = 1,
            columnCount = size
        )
    }
}

fun Modifier.optionableGroupItem(index: Int, isColumn: Boolean = true): Modifier = this.semantics {
    collectionItemInfo = if (isColumn) {
        CollectionItemInfo(
            rowIndex = index,
            rowSpan = 1,
            columnIndex = 0,
            columnSpan = 1
        )
    } else {
        CollectionItemInfo(
            rowIndex = 0,
            rowSpan = 1,
            columnIndex = index,
            columnSpan = 1
        )
    }
}
