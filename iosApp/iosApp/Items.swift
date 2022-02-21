//
//  Items.swift
//  iosApp
//
//  Created by Falcon on 16.02.22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

struct Item {
    enum ItemType {
        case bool
        case `true`
    }

//    var itemType: ItemType
    var val: Any
    
    
    func value<T>() -> T? {
        val as? T
    }
}

var item: Bool? = Item(val: 1).value()
