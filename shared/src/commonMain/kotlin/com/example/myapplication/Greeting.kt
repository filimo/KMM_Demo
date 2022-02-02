package com.example.myapplication

enum class Direction {
	NORTH, SOUTH, WEST, EAST
}

class Greeting {
    fun greeting(vv: Direction): String {
        return "Hello, ${Platform().platform} ${vv}!"
    }
}
