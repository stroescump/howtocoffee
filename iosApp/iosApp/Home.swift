//
//  Home.swift
//  iosApp
//
//  Created by Marius Stroescu on 19.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct HomeView: View {
    private let root: HomeComponent
    
    var body: some View {
        VStack {
            Text("I made it to Home. Lmao.")
            Button(("Button"), action: {
                root.onCoffeeDiagnoseClicked()
            })
        }
    }
    
    init(_ root: HomeComponent) {
        self.root = root
    }
}
