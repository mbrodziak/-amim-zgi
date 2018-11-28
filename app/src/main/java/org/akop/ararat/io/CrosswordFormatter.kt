package org.akop.ararat.io

import org.akop.ararat.core.Crossword

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream


/**
 * The [CrosswordFormatter] interface provides a means to read and write
 * crosswords to/from streams.
 */
interface CrosswordFormatter {

    /**
     * Sets the stream [encoding] for subsequent reads/writes. Almost all
     * formatters are expected to have a default encoding, and not all will
     * support all encodings, due to format restrictions or other reasons.
     */
    fun setEncoding(encoding: String)

    /**
     * Reads contents of an [inputStream] into a [builder]. Check [canRead]
     * to ensure reading is supported.
     */
    @Throws(IOException::class)
    fun read(builder: Crossword.Builder, inputStream: InputStream)

    /**
     * Writes contents of a [crossword] to an [outputStream]. Check [canWrite]
     * to ensure reading is supported.
     */
    @Throws(IOException::class)
    fun write(crossword: Crossword, outputStream: OutputStream)

    /**
     * Returns true if the formatter supports reading from a stream.
     */
    fun canRead(): Boolean

    /**
     * Returns true if the formatter supports writing to a stream.
     */
    fun canWrite(): Boolean
}