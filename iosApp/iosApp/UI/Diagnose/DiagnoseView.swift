//
//  CoffeeDiagnose.swift
//  iosApp
//
//  Created by Marius Stroescu on 19.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import Shared

struct DiagnoseView: View {
    private enum Constants {
        static let buttonPadding: CGFloat = 10
    }
    
    private enum Strings {
        static let lightRoast = "Light roast"
        static let mediumRoast = "Medium roast"
        static let darkRoast = "Dark roast"
    }
    
    // let root: CoffeeDiagnoseComponent
        
    var body: some View {
        ZStack(alignment: .top) {
            Color("Background")
                .ignoresSafeArea()
            
            VStack(spacing: 0) {
                DiagnoseHeaderView()

                VStack(spacing: 15) {
                    CustomCornerButton(
                        color: Color("LightOrange"),
                        image: UIImage(named: "Dark Roast"),
                        text: Strings.darkRoast,
                        action: { print("Dark Roast tapped") },
                        cornersToRound: [.topRight, .bottomLeft])
                    CustomCornerButton(
                        color: Color("StrongOrange"),
                        image: UIImage(named: "Medium Roast"),
                        text: Strings.mediumRoast,
                        action: { print("Medium Roast tapped") },
                        cornersToRound: [.topLeft, .bottomRight])
                    CustomCornerButton(
                        color: Color("LightOrange"),
                        image: UIImage(named: "Light Roast"),
                        text: Strings.lightRoast,
                        action: { print("Light Roast tapped") },
                        cornersToRound: [.topRight, .bottomLeft])
                    
                    RoundedCornerButton(title: "Title", action: {
                        print("hello")
                    })
                }
                .padding([.leading, .trailing])
            }
        }
    }
}
