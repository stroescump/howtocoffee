//
//  EmptyView.swift
//  iosApp
//
//  Created by Marius Stroescu on 19.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct EmptyView: View {
    private let root: RootComponent
    
    var body: some View {
        VStack {
        }
    }
    
    init(_ root: RootComponent) {
        self.root = root
    }
}
