package com.example.taverncat2020

class Card(description: String, type: Int) {
private var description=""
private var type=0
    init {
        this.description=description
        this.type=type
    }
    fun get_des(): String {
        return description
    }
    fun get_type():Int
    {
        return type
    }
}