//
// Created by hyun kim on 19/07/20.
// Copyright (c) 2020 hyun kim. All rights reserved.
//

import Foundation
import SwiftUI
import sample_base

func ReactiveScreen(_ model: ReactiveViewModel) -> some View {
    Screen(model) {
        Column {
            Row {
                SampleTextField("Input new row", model.newWord)
                Button("Add") {
                    model.onClick()
                }
            }
            SampleTextField("Search", model.keyword)
            
            List(model.list.asValue(viewModel: model) as? [String] ?? [String](), id: \.self) { item in
                Text("\(item)")
            }
        }
    }
}
