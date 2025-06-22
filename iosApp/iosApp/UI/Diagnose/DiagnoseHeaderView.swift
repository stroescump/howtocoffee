//
//  DiagnoseHeaderView.swift
//  iosApp
//
//  Created by Alexandre Bevilacqua on 23.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct DiagnoseHeaderView: View {
    private enum Strings {
        static let toCoffeeTitle = "What kind of coffee are you using?"
    }
    
    private enum Constants {
        static let headerHeight: CGFloat = 150
    }

    var body: some View {
        ZStack {
            Text(Strings.toCoffeeTitle)
                .font(.custom("Georgia", size: 30))
                .bold()
                .padding()
        }
        .frame(maxWidth: .infinity)
        .frame(height: Constants.headerHeight)
        .overlay(
            Rectangle()
                .stroke(Color.black, lineWidth: 4)
        )
    }
}

#Preview {
    DiagnoseHeaderView()
}
