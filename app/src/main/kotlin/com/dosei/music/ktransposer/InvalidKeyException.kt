package com.dosei.music.ktransposer

class InvalidKeyException(
    val note: String
) : RuntimeException() {

    override val message: String = "$note is unknown in musical scale."
}