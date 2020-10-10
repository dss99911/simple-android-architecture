package com.example.sampleandroid.view.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sampleandroid.view.SampleScreen
import com.example.sampleandroid.view.view.ViewScreen
import kim.jeonghyeon.androidlibrary.compose.Screen
import kim.jeonghyeon.androidlibrary.compose.push
import kim.jeonghyeon.androidlibrary.extension.resourceToString
import kim.jeonghyeon.sample.compose.R

class ViewTabScreen : SampleScreen() {
    override val title: String = R.string.view.resourceToString()

    @Composable
    override fun compose() {
        super.compose()
    }

    @Composable
    override fun view() {
        ScrollableColumn {
            ViewScreen.screens.forEach {
                Button(
                    onClick = { it.second().push() },
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(it.first)
                }
            }
        }
    }
}

