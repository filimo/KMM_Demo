package com.example.shared



expect class Observable<T>(value: T?) {

    fun setNewValue(value: T?)
//    expect fun getValue()
//    expect fun setValue()
}