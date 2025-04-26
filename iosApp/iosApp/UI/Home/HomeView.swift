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
    let root: HomeComponent
    
    var body: some View {
        ZStack {
            Color("Background")
                .ignoresSafeArea()

            VStack(spacing: 40) {
                Text("?toCoffee")
                    .font(.custom("YourFontName", size: 36))
                    .foregroundColor(.black)
                    .frame(maxWidth: .infinity)
                    .frame(height: UIScreen.main.bounds.height / 6)
                    .background(Color.blue)

                HomeYellowArea(root: root)
                    .padding(.horizontal, 10)
            }
        }
    }
}

struct HomeYellowArea: View {
    let root: HomeComponent

    var body: some View {
        VStack() {
            /*
            HalfCircleShape()
                .fill(Color("LightOrange"))
             */

            // Expandable Gray Area
            GrayButtonsArea(root: root)
            
            // Bottom Semi-Circle
            /*
            HalfCircleShape()
                .fill(Color.black)
                .frame(height: 100)
                .rotationEffect(.degrees(180))
                .fixedSize()
                .clipped()
             */
        }
        .background(Color.yellow)
    }
}

struct GrayButtonsArea: View {
    let root: HomeComponent

    var body: some View {
        HStack(spacing: 0) {
            Button(action: {
                root.onRecipeAgendaClicked()
            }) {
                ZStack {
                    HalfCircleShape()
                        .fill(Color("StrongOrange"))
                        .rotationEffect(.degrees(90))
                        .aspectRatio(1, contentMode: .fit)

                    Text("recipe\nagenda")
                        .foregroundColor(.white)
                        .multilineTextAlignment(.center)
                        .padding()
                }
            }
            .frame(maxWidth: .infinity, minHeight: 200)

            Button(action: {
                //
            }) {
                ZStack {
                    HalfCircleShape()
                        .fill(Color.green)
                        .rotationEffect(.degrees(-90))
                        .aspectRatio(1, contentMode: .fit)

                    Text("coffee\nplaces\nnearby")
                        .foregroundColor(.white)
                        .multilineTextAlignment(.center)
                        .padding()
                }
            }
            .frame(maxWidth: .infinity, minHeight: 200)
        }
        .frame(maxWidth: .infinity)
        .background(Color.gray)
    }
}


struct HomeVStackView: View {
    let root: HomeComponent
    
    var body: some View {
        VStack() {
            Button(action: {
                root.onFindYourTasteClicked()
            }) {
                Text("find your taste")
            }
            .modifier(HomeButtonModifier(color: Color("LightOrange"), shape: .top))
            
            HStack() {
                Button(action: {
                    root.onRecipeAgendaClicked()
                }) {
                    Text("recipe\nagenda")
                }
                .modifier(HomeButtonModifier(color: Color("StrongOrange"), shape: .left))
                
                Button(action: {
                    //
                }) {
                    Text("coffee\nplaces\nnearby")
                }
                .modifier(HomeButtonModifier(color: .green, shape: .right))
            }
            .background(.gray)
            
            Button(action: {
                root.onCoffeeDiagnoseClicked()
            }) {
                Text("diagnose your brew")
            }
            .modifier(HomeButtonModifier(color: .black, shape: .bottom))
        }
        .frame(maxWidth: .infinity)
    }
}

struct HomeButtonModifier: ViewModifier {
    enum ShapeType {
        case top, left, right, bottom
    }
    
    let color: Color
    let shape: ShapeType
    
    func body(content: Content) -> some View {
        content
            .font(.custom("HelveticaNeue-Light", size: 20))
            .foregroundColor(shape == .top ? .black : .white)
            .multilineTextAlignment(.center)
        /*
            .frame(
                width: shape == .left || shape == .right ? 500 : 300,
                height: shape == .left || shape == .right ? 250 : 100
            )
         */
            .background(
                HalfCircleShape()
                    .fill(color)
                    .rotationEffect(rotation(for: shape))
            )
            .shadow(color: .black.opacity(0.1), radius: 5, x: 0, y: 3)
    }
    
    private func rotation(for shape: ShapeType) -> Angle {
        switch shape {
        case .top:
            return .degrees(0)
        case .left:
            return .degrees(90)
        case .right:
            return .degrees(-90)
        case .bottom:
            return .degrees(180)
        }
    }
}
