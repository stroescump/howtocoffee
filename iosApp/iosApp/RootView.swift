//
//  RootView.swift
//  iosApp
//
//  Created by Marius Stroescu on 19.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//


//
//  RootView.swift
//  app-ios
//
//  Created by Arkadii Ivanov on 13/05/2022.
//

import SwiftUI
import Shared

struct RootView: View {
    private let root: RootComponent
    
    init(_ root: RootComponent) {
        self.root = root
    }
    
    var body: some View {
        StackView(
            stackValue: StateValue(root.stack),
            getTitle: { _ in "Heh" },
            onBack: root.onBackClicked
        ) { child in
            switch child {
            case let child as RootComponentScreens.CoffeeDiagnose: CoffeeDiagnoseView(child.coffeeDiagnoseComponent)
            case let child as RootComponentScreens.Home: HomeView(root: child.homeComponent)
            default: EmptyView()
            }
        }
    }
}

/*
struct RootView_Previews: PreviewProvider {
    static var previews: some View {
        RootView(AppRootComponent.companion.createAppRootComponent())
    }
}
*/
