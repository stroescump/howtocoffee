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
    private enum Constants {
        static let buttonPadding: CGFloat = 10
    }

    private enum Strings {
        static let findYourTaste = "Find your taste"
        static let diagnoseBrew = "Diagnose brew"
        static let recipeAgenda = "Recipe aganda"
        static let coffeePlacesNearby = "Coffee places nearby"
        static let na = "N/A"
    }
    
    let root: HomeComponent

    var body: some View {
        ZStack {
            Color("Background")
                .ignoresSafeArea()

            VStack(spacing: 0) {
                HomeHeaderView()

                VStack(spacing: Constants.buttonPadding) {
                    ZStack {
                        HStack(spacing: Constants.buttonPadding) {
                            CustomCornerButton(
                                color: Color("LightOrange"),
                                text: Strings.findYourTaste,
                                action: {
                                    root.onFindYourTasteClicked()
                                },
                                cornersToRound: [.topLeft, .topRight, .bottomLeft]
                            )
                            .padding([.leading, .top], Constants.buttonPadding)

                            VStack(spacing: Constants.buttonPadding) {
                                CustomCornerButton(
                                    color: Color("StrongOrange"),
                                    text: Strings.na,
                                    action: { print("Top Right tapped") },
                                    cornersToRound: [.topLeft, .topRight, .bottomLeft, .bottomRight]
                                )
                                CustomCornerButton(
                                    color: .black,
                                    text: Strings.diagnoseBrew,
                                    action: {
                                        root.onCoffeeDiagnoseClicked()
                                    },
                                    cornersToRound: [.topLeft, .bottomRight]
                                )
                            }
                            .padding([.top, .trailing], Constants.buttonPadding)
                        }
                    }
                    .aspectRatio(1, contentMode: .fit)

                    ZStack {
                        HStack(spacing: Constants.buttonPadding) {
                            VStack(spacing: Constants.buttonPadding) {
                                CustomCornerButton(
                                    color: .black,
                                    text: Strings.recipeAgenda,
                                    action: {
                                        root.onRecipeAgendaClicked()
                                    },
                                    cornersToRound: [.topLeft, .bottomLeft, .bottomRight]
                                )
                                CustomCornerButton(
                                    color: .black,
                                    text: Strings.na,
                                    action: { print("Bottom Right 2 tapped") },
                                    cornersToRound: [.topRight, .bottomLeft]
                                )
                            }
                            .padding([.leading, .bottom], Constants.buttonPadding)

                            VStack(spacing: Constants.buttonPadding) {
                                CustomCornerButton(
                                    color: Color("StrongOrange"),
                                    text: Strings.coffeePlacesNearby,
                                    action: { print("Top Right 3 tapped") },
                                    cornersToRound: [.topRight, .bottomLeft, .bottomRight]
                                )
                                CustomCornerButton(
                                    color: Color("LightOrange"),
                                    text: Strings.na,
                                    action: { print("Bottom Right 3 tapped") },
                                    cornersToRound: [.topLeft, .bottomRight]
                                )
                            }
                            .padding([.trailing, .bottom], Constants.buttonPadding)
                        }
                    }
                    .aspectRatio(1, contentMode: .fit)
                }
            }
        }
    }
}
