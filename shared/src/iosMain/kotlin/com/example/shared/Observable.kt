package com.example.shared

import kotlinx.coroutines.flow.MutableStateFlow


actual class Observable<T> actual constructor(value: T?) {

    val flow = MutableStateFlow(value)

    actual fun setNewValue(value: T?) {
        flow.value = value
    }

    fun <A> setValue(value: A) {
        setNewValue(value as T)
    }
}
