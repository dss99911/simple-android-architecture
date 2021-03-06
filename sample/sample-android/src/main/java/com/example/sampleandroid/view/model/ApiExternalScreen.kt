package com.example.sampleandroid.view.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sampleandroid.view.widget.SampleTextField
import kim.jeonghyeon.androidlibrary.compose.Screen
import kim.jeonghyeon.androidlibrary.compose.unaryPlus
import kim.jeonghyeon.androidlibrary.compose.widget.Button
import kim.jeonghyeon.androidlibrary.compose.widget.ScrollableColumn
import kim.jeonghyeon.androidlibrary.extension.resourceToString
import kim.jeonghyeon.sample.compose.R
import kim.jeonghyeon.sample.viewmodel.ApiExternalViewModel

@Composable
fun ApiExternalScreen(model: ApiExternalViewModel) {
    Screen(model) {
        Column {
            Row {
                SampleTextField("Input Git hub search keyword", model.input)
                Button(R.string.call.resourceToString()) { model.onClickCall() }
            }
            ScrollableColumn(+model.repoList, Modifier.weight(1f)) {
                Text(it)
            }
        }
    }
}
// TODO reactive way.
//@Composable
//fun ApiExternalScreen2(model: ApiExternalViewModel2) {
//    Screen(model) {
//        Column {
//            Row {
//                SampleTextField("Input Git hub search keyword", model.input)
//                Button(R.string.call.resourceToString(), model.clickCall)
//            }
//            ScrollableColumn(+model.repoList, Modifier.weight(1f)) {
//                Text(it)
//            }
//        }
//    }
//}