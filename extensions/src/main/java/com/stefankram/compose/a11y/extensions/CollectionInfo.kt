package com.stefankram.compose.a11y.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.CollectionInfo
import androidx.compose.ui.semantics.CollectionItemInfo
import androidx.compose.ui.semantics.collectionInfo
import androidx.compose.ui.semantics.collectionItemInfo
import androidx.compose.ui.semantics.semantics

fun Modifier.columnCollectionInfo(size: Int): Modifier = this.semantics {
    collectionInfo = CollectionInfo(
        rowCount = size,
        columnCount = 1
    )
}

fun Modifier.columnCollectionItemInfo(index: Int): Modifier = this.semantics {
    collectionItemInfo = CollectionItemInfo(
        rowIndex = index,
        rowSpan = 1,
        columnIndex = 0,
        columnSpan = 1
    )
}

fun Modifier.rowCollectionInfo(size: Int): Modifier = this.semantics {
    collectionInfo = CollectionInfo(
        rowCount = 1,
        columnCount = size
    )
}

fun Modifier.rowCollectionItemInfo(index: Int): Modifier = this.semantics {
    collectionItemInfo = CollectionItemInfo(
        rowIndex = 0,
        rowSpan = 1,
        columnIndex = index,
        columnSpan = 1
    )
}
