package com.example.kmmapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*


class Repository {

    @Throws(Exception::class)
    suspend fun getControlsList() : List<Control> {
		delay(2000)

		return listOf(
			Control(true, "test 1", "label 1"),
			Control(true, "test 2", "label 2"),
			Control(false, null, "Who cares")
		)
    }
}
