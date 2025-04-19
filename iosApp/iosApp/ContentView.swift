import SwiftUI
import Shared

struct RootContentView: View {
    private let rootComponent = AppRootComponent.companion.createAppRootComponent()

    var body: some View {
        ChildStackView(stackValue: rootComponent.stack) { screen in
            screenFor(child: screen)
        }
    }

    @ViewBuilder
    private func screenFor(child: AnyObject) -> some View {
        switch child {
        case let component as HomeComponent: HomeView(component)

        case let component as CoffeeDiagnoseComponent:CoffeeDiagnoseView(component)

        case let component as RecipeAgendaComponent: RecipeAgendaView(component)

        case let component as FindYourTasteComponent:FindYourTasteView(component)

        default:
            Text("Unknown screen")
        }
    }
}

struct ChildStackView<Screen: RootComponentScreens, Content: View>: View {
    let stackValue: Value<ChildStack<RootComponent, Screen>>
    let content: (Screen) -> Content

    @State private var currentChild: Screen?

    var body: some View {
        ZStack {
            if let instance = currentChild {
                content(instance)
            } else {
                Text("Loading...")
            }
        }
        .onAppear {
            stackValue.watch { stack in
                currentChild = stack.active.instance
            }
        }
    }
}

