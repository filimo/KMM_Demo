import Combine
import shared
import SwiftUI

struct ContentView: View {
    let greet = Greeting().greeting(vv: .east)
    @State var repo: [Control] = []
    let repository = Repository()

    var body: some View {
        VStack {
            Text(greet)
            ForEach(repo, id: \.self) { item in
                if item.visibility {
                    Text(item.label ?? "non")
                }
            }
        }
        .onAppear {
            repository.getControlsList { repo, error in
                if let error = error {
                    print(error)
                    return
                }

                self.repo = repo!
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
