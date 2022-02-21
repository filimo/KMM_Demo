package com.example.shared

import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KProperty


class ValueDelegate<T>(val item: DataModelItem<T>? = null, var staticValue: MutableStateFlow<T>? = null)

@Suppress("NOTHING_TO_INLINE")
inline operator fun <T> ValueDelegate<T?>.getValue(thisObj: Any?, property: KProperty<*>): Observable<T?>? {
    return item?.observable
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun <T> ValueDelegate<T>.setValue(thisObj: Any?, property: KProperty<*>, value: T?) {
    item?.setNewValue(value)
//    else
//        staticValue = value // Remove?
}