package com.example.shared


class DataModelItem<T>(
    val observable: Observable<T?>
) {
    fun setNewValue(newValue: T?) {
        // calc newValue and etc. and return as? T
        observable.setNewValue(newValue)
    }
}