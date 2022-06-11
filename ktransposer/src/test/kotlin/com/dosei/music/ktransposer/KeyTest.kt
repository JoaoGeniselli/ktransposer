package com.dosei.music.ktransposer

import com.dosei.music.ktransposer.Key.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KeyTest {

    @Test
    fun `test plus`() {
        val key = C

        val third = key + 4
        val fifth = key + 7
        val minorNinth = key + 13

        assertEquals(E, third)
        assertEquals(G, fifth)
        assertEquals(CSharp, minorNinth)
    }

    @Test
    fun `test minus`() {
        val key = C

        val minorSeventh = key - 2
        val fifth = key - 5
        val second = key - 10

        assertEquals(Bb, minorSeventh)
        assertEquals(G, fifth)
        assertEquals(D, second)
    }

    @Test
    fun `test diff`() {
        val key = C

        val diffBb = key diff Bb
        val diffG = key diff G
        val diffD = key diff D

        assertEquals(10, diffBb)
        assertEquals(7, diffG)
        assertEquals(2, diffD)
    }
}