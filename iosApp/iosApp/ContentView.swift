import SwiftUI
import Shared

struct ContentView: View {
    @State private var showContent = true
    
    // This is a random example of a component. This is not where or how it should be created, just wanted to fix the dependecy issues.
     
    private let component = HomeComponent(componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle()), goToCoffeeDiagnose: {}, goToFindYourTaste: {}, goToRecipeAgenda: {})
    
    var body: some View {
        VStack {
            Button("Click me!") {
                component.onCoffeeDiagnoseClicked()
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
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
