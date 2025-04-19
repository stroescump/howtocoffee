import SwiftUI
import Shared

struct ContentView: View {
    let root: AppRootComponent

    var body: some View {
        Text("content")
        /*
        StackView(
            stackValue: StateValue(root.stack),
            getTitle: {
                switch $0 {
                case is Screens.Home: return "List"
                case is Screens.CoffeeDiagnose : return "Details"
                case is Screens.FindYourTaste : return "Details"
                case is Screens.RecipeAgenda : return "Details"
                default: return ""
                }
            },
            onBack: root.onBackClicked,
            childContent: {
                switch $0 {
                case let screen as SharedScreens.Home: HomeView(component: screen.)
                default: EmptyView()
                }
            }
        )
         */
    }
}

struct HomeView: View {
    let component: HomeComponent
    var body: some View {
        Text("Home")
    }
}

/*
struct ContentView: View {
    @State private var showContent = true
    var root: AppRootComponent
    
    var body: some View {
        VStack {
            Button("Click me!") {
                withAnimation {
                    showContent = !showContent
                }
            }

            if showContent {
                VStack(spacing: 16) {
                    Image(systemName: "swift")
                        .font(.system(size: 200))
                        .foregroundColor(.accentColor)
                    Text("SwiftUI: Example")
                }
                .transition(.move(edge: .top).combined(with: .opacity))
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}*/

struct SecondView: View {
    var body: some View {
        VStack {
            Button("Click me!") {
                
            }
        }
    }
}

/*
struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
*/
