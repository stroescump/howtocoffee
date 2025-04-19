import SwiftUI
import Shared

@main
struct CoffeeApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    private var appDelegate: AppDelegate

    var body: some Scene {
        WindowGroup {
            RootView(appDelegate.root)
        }
    }
}

import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    
    lazy var root: RootComponent = AppRootComponent(
        componentContext: DefaultComponentContext(
            lifecycle: ApplicationLifecycle()
        )
    )
}

