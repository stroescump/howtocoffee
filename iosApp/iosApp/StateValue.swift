//
//  StateValue.swift
//  iosApp
//
//  Created by Alexandre Bevilacqua on 19.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Shared

@propertyWrapper struct StateValue<T : AnyObject>: DynamicProperty {
    @ObservedObject
    private var obj: ObservableValue<T>

    var wrappedValue: T { obj.value }

    init(_ value: Value<T>) {
        obj = ObservableValue(value)
    }
}
