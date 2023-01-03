package com.stefankram.compose.a11y.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stefankram.compose.a11y.examples.theme.Theme
import com.stefankram.compose.a11y.extensions.columnCollectionInfo
import com.stefankram.compose.a11y.extensions.columnCollectionItemInfo
import com.stefankram.compose.a11y.extensions.rowCollectionInfo
import com.stefankram.compose.a11y.extensions.rowCollectionItemInfo

@Composable
fun CollectionInfoExample() {
    Column {
        LazyColumn(modifier = Modifier.columnCollectionInfo(3)) {
            item {
                Text(text = "First", modifier = Modifier.columnCollectionItemInfo(0))
            }
            item {
                Text(text = "Second", modifier = Modifier.columnCollectionItemInfo(1))
            }
            item {
                Text(text = "Third", modifier = Modifier.columnCollectionItemInfo(2))
            }
        }

        LazyRow(modifier = Modifier.rowCollectionInfo(3)) {
            item {
                Text(text = "First", modifier = Modifier.rowCollectionItemInfo(0))
            }
            item {
                Text(text = "Second", modifier = Modifier.rowCollectionItemInfo(1))
            }
            item {
                Text(text = "Third", modifier = Modifier.rowCollectionItemInfo(2))
            }
        }
    }
}

@Preview
@Composable
fun CollectionInfoExamplePreview() {
    Theme {
        CollectionInfoExample()
    }
}
