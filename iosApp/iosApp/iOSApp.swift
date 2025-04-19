import SwiftUI
import Shared


@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate

    var body: some Scene {
        WindowGroup {
            ContentView(root: appDelegate.root)
        }
    }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    let root = AppRootComponent(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle()))
}
