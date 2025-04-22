//
//  CoffeeDiagnose.swift
//  iosApp
//
//  Created by Marius Stroescu on 19.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct CoffeeDiagnoseView: View {
    private let root: CoffeeDiagnoseComponent
    
    var body: some View {
            Button(("Back"), action: {
                root.goBack()
            })
    
    }
    
    init(_ root: CoffeeDiagnoseComponent) {
        self.root = root
    }
}
