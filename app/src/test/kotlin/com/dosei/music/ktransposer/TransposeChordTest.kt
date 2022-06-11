package com.dosei.music.ktransposer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TransposeChordTest {

    @Test
    fun `test transpose chord negative`() {
        val result = TransposeChord.create().invoke(
            chord = "Cm7/Bb",
            semitones = -2,
            preferredModifier = NoteModifier.AUTO
        )
        assertEquals("Bbm7/G#", result)
    }

    @Test
    fun `test transpose chord positive`() {
        val result = TransposeChord.create().invoke(
            chord = "D#7+",
            semitones = 5,
            preferredModifier = NoteModifier.AUTO
        )
        assertEquals("G#7+", result)
    }
}
