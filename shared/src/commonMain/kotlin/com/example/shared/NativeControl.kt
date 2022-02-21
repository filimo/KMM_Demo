package com.example.shared

import kotlinx.coroutines.flow.MutableStateFlow


data class NativeControl(
    val type: ControlType,

    var visibility: Observable<Any?>,
    var value: Observable<Any?>,
    var label: MutableStateFlow<String?>,

    val children: List<NativeControl>?,
    val properties: Map<String, MutableStateFlow<Any?>>
)


enum class ControlType {
    CONTAINER, CHECKBOX, EDIT_TEXT, TEXT_LITERAL
}