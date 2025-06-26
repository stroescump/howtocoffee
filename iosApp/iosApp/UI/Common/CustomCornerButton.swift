//
//  HalfCircleShape.swift
//  iosApp
//
//  Created by Alexandre Bevilacqua on 26.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct CustomCornerButton: View {
    var color: Color
    var image: UIImage? = nil
    var text: String
    var action: () -> Void
    var cornersToRound: [UIRectCorner]

    var body: some View {
        Button(action: action) {
            GeometryReader { geo in
                let radius = min(geo.size.width, geo.size.height) / 2

                if #available(iOS 16.0, *) {
                    ZStack {
                        color
                        VStack {
                            if image != nil {
                                Image(uiImage: image!)
                                    .resizable()
                                    .frame(width: 100, height: 100)
                            }
                            Text(text)
                                .foregroundColor(.white)
                                .bold()
                                .multilineTextAlignment(.center)
                                .padding()
                        }
                    }
                    .clipShape(
                        .rect(
                            topLeadingRadius: cornersToRound.contains(.topLeft) ? radius : 0,
                            bottomLeadingRadius: cornersToRound.contains(.bottomLeft) ? radius : 0,
                            bottomTrailingRadius: cornersToRound.contains(.bottomRight) ? radius : 0,
                            topTrailingRadius: cornersToRound.contains(.topRight) ? radius : 0
                        )
                    )
                } else {
                    // Fallback on earlier versions
                    ZStack {
                        color
                        Text(text)
                            .foregroundColor(.white)
                            .bold()
                            .multilineTextAlignment(.center)
                            .padding()
                    }
                }
            }
        }
    }
}
