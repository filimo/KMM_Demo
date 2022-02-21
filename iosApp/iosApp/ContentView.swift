import SwiftUI

struct ContentView: View {
    @ObservedObject var service = Service.shared

    var body: some View {
        VStack {
            Text(String(describing: service.visibility))

            Button("Set") {
                service.visibility?.toggle()
            }

            HStack {
                Text("value nul:")

                TextField("", text: $service.valueNull)
            }

            HStack {
                Text("value: ")
                TextField("", text: $service.value)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
