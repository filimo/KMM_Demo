import Foundation

//struct Item {
//    enum ItemType {
//        case itemBool
//        case itemTrue
//    }
//
//    var itemType: ItemType
//    var val: Any
//
//    func value<T>() -> T? {
//        switch itemType {
//        case .itemBool:
//            return val as? T
//        case .itemTrue:
//            return val as? T
//        }
//    }
//}
//
//var item: Bool? = Item(itemType: .itemTrue, val: false).value()
//
//print(item ?? "")

enum ItemValue {
    case bool(Bool)
    case string(String)
    case number(NSNumber)
    case strings([String])
}

var items = [ItemValue.bool(true), .number(111), .string("sdfsdf")]

print(items[0], items[1], items[2], items[0])
