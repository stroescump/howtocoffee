//
//  Untitled.swift
//  iosApp
//
//  Created by Alexandre Bevilacqua on 23.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct HomeHeaderView: View {
    private enum Strings {
        static let toCoffeeTitle = "?toCoffee"
    }
    
    private enum Constants {
        static let headerHeight: CGFloat = 100
    }

    var body: some View {
        ZStack {
            Color.blue
            Text(Strings.toCoffeeTitle)
                .font(.custom("Georgia", size: 40))
                .bold()
        }
        .frame(maxWidth: .infinity)
        .frame(height: Constants.headerHeight)
    }
}
