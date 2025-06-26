//
//  RoundedCornerButton.swift
//  iosApp
//
//  Created by Alexandre Bevilacqua on 26.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct RoundedCornerButton: View {
    let title: String
    let action: () -> Void
    
    var body: some View {
        Button(title) {
            action()
        }
        .frame(maxWidth: .infinity, minHeight: 50)
        .background(Color.black)
        .foregroundColor(.white)
        .cornerRadius(25)
    }
}

#Preview {
    ZStack {
        Color.red.ignoresSafeArea()
        VStack {
            RoundedCornerButton(title: "Mon Bouton", action: {})
        }
        .frame(maxWidth: .infinity)
        .padding(.horizontal, 0)
    }
}
