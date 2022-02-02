package com.example.myapplication

//import io.ktor.utils.io.core.*
//import kotlinx.coroutines.*
//import kotlinx.coroutines.channels.*
//import kotlinx.coroutines.flow.*
//
//fun <T> ConflatedBroadcastChannel<T>.wrap(): CFlow<T> = CFlow(asFlow())
//
//fun <T> Flow<T>.wrap(): CFlow<T> = CFlow(this)
//
//class CFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
//    fun watch(block: (T) -> Unit): Closeable {
//        val job = Job(/*ConferenceService.coroutineContext[Job]*/)
//
//        onEach {
//            block(it)
//        }.launchIn(CoroutineScope(job))
//
//        return object : Closeable {
//            override fun close() {
//                job.cancel()
//            }
//        }
//    }
//}

import io.ktor.utils.io.core.Closeable
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)
class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): Closeable {
        val job = Job()

        onEach {
            block(it)
        }.launchIn(CoroutineScope(Dispatchers.Main + job))

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }
}