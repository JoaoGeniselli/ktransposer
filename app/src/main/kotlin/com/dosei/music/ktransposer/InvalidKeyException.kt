package com.dosei.music.ktransposer

/**
 * An invalid Key exception during transposition logic.
 *
 * Ex.:
 *
 * "C#".toNote() = Key.CSharp
 *
 * "R".toNote() = InvalidKeyException is thrown
 *
 * @property unknownKey the problematic Key.
 */
class InvalidKeyException(
    val unknownKey: String
) : RuntimeException() {

    override val message: String = "$unknownKey is unknown in musical scale."
}