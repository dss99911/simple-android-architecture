/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.architecture.blueprints.todoapp.addedittask

import com.example.android.architecture.blueprints.todoapp.BR
import com.example.android.architecture.blueprints.todoapp.R
import kim.jeonghyeon.androidlibrary.architecture.mvvm.BaseFragment
import kim.jeonghyeon.androidlibrary.architecture.mvvm.bindingViewModel
import org.koin.core.parameter.parametersOf

/**
 * Main UI for the add task screen. Users can enter a task title and description.
 */
class AddEditTaskFragment : BaseFragment() {

    override val layoutId = R.layout.addtask_frag

    val viewModel: AddEditTaskViewModel by bindingViewModel(BR.viewmodel) {
        parametersOf(getNavArgs())
    }
}