package com.dosei.music.ktransposer

import com.dosei.music.ktransposer.NoteModifier.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class KeyMapperTest {

    @Test
    fun `test successful key mapping`() {
        assertEquals(Key.C, "B#".toKey())
        assertEquals(Key.C, "C".toKey())
        assertEquals(Key.CSharp, "C#".toKey())
        assertEquals(Key.CSharp, "Db".toKey())
        assertEquals(Key.D, "D".toKey())
        assertEquals(Key.DSharp, "D#".toKey())
        assertEquals(Key.DSharp, "Eb".toKey())
        assertEquals(Key.E, "Fb".toKey())
        assertEquals(Key.E, "E".toKey())
        assertEquals(Key.F, "E#".toKey())
        assertEquals(Key.F, "F".toKey())
        assertEquals(Key.FSharp, "F#".toKey())
        assertEquals(Key.FSharp, "Gb".toKey())
        assertEquals(Key.G, "G".toKey())
        assertEquals(Key.GSharp, "G#".toKey())
        assertEquals(Key.GSharp, "Ab".toKey())
        assertEquals(Key.A, "A".toKey())
        assertEquals(Key.Bb, "A#".toKey())
        assertEquals(Key.Bb, "Bb".toKey())
        assertEquals(Key.B, "B".toKey())
        assertEquals(Key.B, "Cb".toKey())
    }

    @Test
    fun `test invalid key`() {
        assertThrows<InvalidKeyException> {
            "X".toKey()
        }
    }

    @Test
    fun `test to note or null`() {
        assertEquals(Key.C, "C".toKeyOrNull())
        assertNull("H".toKeyOrNull())
    }

    @Test
    fun `test map to note - AUTO`() {
        assertEquals("C", Key.C.toNoteName(AUTO))
        assertEquals("C#", Key.CSharp.toNoteName(AUTO))
        assertEquals("D", Key.D.toNoteName(AUTO))
        assertEquals("D#", Key.DSharp.toNoteName(AUTO))
        assertEquals("E", Key.E.toNoteName(AUTO))
        assertEquals("F", Key.F.toNoteName(AUTO))
        assertEquals("F#", Key.FSharp.toNoteName(AUTO))
        assertEquals("G", Key.G.toNoteName(AUTO))
        assertEquals("G#", Key.GSharp.toNoteName(AUTO))
        assertEquals("A", Key.A.toNoteName(AUTO))
        assertEquals("Bb", Key.Bb.toNoteName(AUTO))
        assertEquals("B", Key.B.toNoteName(AUTO))
    }

    @Test
    fun `test map to note - SHARP`() {
        assertEquals("C", Key.C.toNoteName(SHARP))
        assertEquals("C#", Key.CSharp.toNoteName(SHARP))
        assertEquals("D", Key.D.toNoteName(SHARP))
        assertEquals("D#", Key.DSharp.toNoteName(SHARP))
        assertEquals("E", Key.E.toNoteName(SHARP))
        assertEquals("F", Key.F.toNoteName(SHARP))
        assertEquals("F#", Key.FSharp.toNoteName(SHARP))
        assertEquals("G", Key.G.toNoteName(SHARP))
        assertEquals("G#", Key.GSharp.toNoteName(SHARP))
        assertEquals("A", Key.A.toNoteName(SHARP))
        assertEquals("A#", Key.Bb.toNoteName(SHARP))
        assertEquals("B", Key.B.toNoteName(SHARP))
    }

    @Test
    fun `test map to note - FLAT`() {
        assertEquals("C", Key.C.toNoteName(FLAT))
        assertEquals("Db", Key.CSharp.toNoteName(FLAT))
        assertEquals("D", Key.D.toNoteName(FLAT))
        assertEquals("Eb", Key.DSharp.toNoteName(FLAT))
        assertEquals("E", Key.E.toNoteName(FLAT))
        assertEquals("F", Key.F.toNoteName(FLAT))
        assertEquals("Gb", Key.FSharp.toNoteName(FLAT))
        assertEquals("G", Key.G.toNoteName(FLAT))
        assertEquals("Ab", Key.GSharp.toNoteName(FLAT))
        assertEquals("A", Key.A.toNoteName(FLAT))
        assertEquals("Bb", Key.Bb.toNoteName(FLAT))
        assertEquals("B", Key.B.toNoteName(FLAT))
    }
}