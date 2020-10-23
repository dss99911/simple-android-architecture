package com.example.sampleandroid.view.model

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import kim.jeonghyeon.androidlibrary.compose.unaryPlus
import kim.jeonghyeon.androidlibrary.extension.resourceToString
import kim.jeonghyeon.sample.compose.R
import kim.jeonghyeon.sample.viewmodel.ApiPollingViewModel
import kim.jeonghyeon.type.isSuccess

@Composable
fun ApiPollingScreen(model: ApiPollingViewModel) {
    Column {
        Text("fail count ${+model.count}")
        if ((+model.status).isSuccess()) {
            Text("result ${+model.result}")
        }
    }
}