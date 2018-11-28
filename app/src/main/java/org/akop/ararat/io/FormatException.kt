package org.akop.ararat.io


class FormatException(message: String, cause: Throwable?) : RuntimeException(message, cause) {

    constructor(message: String) : this(message, null)
}