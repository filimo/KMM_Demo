package com.example.shared

import kotlinx.coroutines.flow.MutableStateFlow


class Repository {

    private val dataModel = DataModel()

    fun getNativeControlList() = listOf(
        NativeControl(
            type = ControlType.CONTAINER,
            visibility = dataModel.items["itemTrue"]!!.observable,
            value = dataModel.items["itemNull"]!!.observable,
            label = MutableStateFlow("Label 1"),
            children = listOf(
                NativeControl(
                    type = ControlType.TEXT_LITERAL,
                    visibility = dataModel.items["itemBool"]!!.observable,
                    value = dataModel.items["itemStringValue"]!!.observable,
//                    value = ValueDelegate(item = dataModel.items["itemStringValue"]),
                    label = MutableStateFlow("Text literal"),
                    children = null,
                    properties = emptyMap()
                ),
                NativeControl(
                    type = ControlType.EDIT_TEXT,
                    visibility = dataModel.items["itemTrue"]!!.observable,
                    value = dataModel.items["itemStringValue"]!!.observable,
//                    value = ValueDelegate(item = dataModel.items["itemStringValue"]),
                    label = MutableStateFlow("Text edit"),
                    children = null,
                    properties = emptyMap()
                ),
                NativeControl(
                    type = ControlType.CHECKBOX,
                    visibility = dataModel.items["itemTrue"]!!.observable,
                    value = dataModel.items["itemBool"]!!.observable,
//                    value = ValueDelegate(item = dataModel.items["itemBool"]),
                    label = MutableStateFlow("Checkbox that hide text literal"),
                    children = null,
                    properties = emptyMap()
                ),
//                NativeControl(
//                    type = ControlType.CHECKBOX,
//                    visibility = MutableStateFlow(true),
//                    value = ValueDelegate(staticValue =  MutableStateFlow(true)),
//                    label = MutableStateFlow("Static checkbox"),
//                    children = null,
//                    properties = emptyMap()
//                )
            ),
            properties = emptyMap()
        ),
        NativeControl(
            type = ControlType.CONTAINER,
            visibility = dataModel.items["itemTrue"]!!.observable,
            value = dataModel.items["itemNull"]!!.observable,
            label = MutableStateFlow("Label 1"),
            children = listOf(
                NativeControl(
                    type = ControlType.TEXT_LITERAL,
                    visibility = dataModel.items["itemBool"]!!.observable,
                    value = dataModel.items["itemNull"]!!.observable,
                    label = MutableStateFlow("Empty text"),
                    children = null,
                    properties = emptyMap()
                )
            ),
            properties = mapOf(
                "hideOnEmpty" to MutableStateFlow(true)
            )
        )
    )

}