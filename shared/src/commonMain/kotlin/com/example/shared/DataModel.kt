package com.example.shared


class DataModel {

    val items = mapOf<String, DataModelItem<Any?>>(
        "itemBool" to DataModelItem(Observable(true)),
        "itemTrue" to DataModelItem(Observable(true)),
        "itemNull" to DataModelItem(Observable(null)),
        "itemStringLabel" to DataModelItem(Observable("Label")),
        "itemStringValue" to DataModelItem(Observable("string value")),
    )
}

