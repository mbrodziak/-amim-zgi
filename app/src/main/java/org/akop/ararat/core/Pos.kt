package org.akop.ararat.core

data class Pos(var r: Int = 0, var c: Int = 0) {

    fun set(r: Int, c: Int) {
        this.r = r
        this.c = c
    }
}