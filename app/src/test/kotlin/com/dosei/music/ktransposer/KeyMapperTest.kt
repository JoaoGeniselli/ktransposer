package com.dosei.music.ktransposer

import com.dosei.music.ktransposer.Key.*
import com.dosei.music.ktransposer.NoteModifier.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class KeyMapperTest {

    @Test
    fun `test successful key mapping`() {
        assertEquals(C, "B#".toKey())
        assertEquals(C, "C".toKey())
        assertEquals(CSharp, "C#".toKey())
        assertEquals(CSharp, "Db".toKey())
        assertEquals(D, "D".toKey())
        assertEquals(DSharp, "D#".toKey())
        assertEquals(DSharp, "Eb".toKey())
        assertEquals(E, "Fb".toKey())
        assertEquals(E, "E".toKey())
        assertEquals(F, "E#".toKey())
        assertEquals(F, "F".toKey())
        assertEquals(FSharp, "F#".toKey())
        assertEquals(FSharp, "Gb".toKey())
        assertEquals(G, "G".toKey())
        assertEquals(GSharp, "G#".toKey())
        assertEquals(GSharp, "Ab".toKey())
        assertEquals(A, "A".toKey())
        assertEquals(Bb, "A#".toKey())
        assertEquals(Bb, "Bb".toKey())
        assertEquals(B, "B".toKey())
        assertEquals(B, "Cb".toKey())
    }

    @Test
    fun `test invalid key`() {
        assertThrows<InvalidKeyException> {
            "X".toKey()
        }
    }

    @Test
    fun `test to note or null`() {
        assertEquals(C, "C".toKeyOrNull())
        assertNull("H".toKeyOrNull())
    }

    @Test
    fun `test map to note - AUTO`() {
        assertEquals("C", C.toNoteName(AUTO))
        assertEquals("C#", CSharp.toNoteName(AUTO))
        assertEquals("D", D.toNoteName(AUTO))
        assertEquals("D#", DSharp.toNoteName(AUTO))
        assertEquals("E", E.toNoteName(AUTO))
        assertEquals("F", F.toNoteName(AUTO))
        assertEquals("F#", FSharp.toNoteName(AUTO))
        assertEquals("G", G.toNoteName(AUTO))
        assertEquals("G#", GSharp.toNoteName(AUTO))
        assertEquals("A", A.toNoteName(AUTO))
        assertEquals("Bb", Bb.toNoteName(AUTO))
        assertEquals("B", B.toNoteName(AUTO))
    }

    @Test
    fun `test map to note - SHARP`() {
        assertEquals("C", C.toNoteName(SHARP))
        assertEquals("C#", CSharp.toNoteName(SHARP))
        assertEquals("D", D.toNoteName(SHARP))
        assertEquals("D#", DSharp.toNoteName(SHARP))
        assertEquals("E", E.toNoteName(SHARP))
        assertEquals("F", F.toNoteName(SHARP))
        assertEquals("F#", FSharp.toNoteName(SHARP))
        assertEquals("G", G.toNoteName(SHARP))
        assertEquals("G#", GSharp.toNoteName(SHARP))
        assertEquals("A", A.toNoteName(SHARP))
        assertEquals("A#", Bb.toNoteName(SHARP))
        assertEquals("B", B.toNoteName(SHARP))
    }

    @Test
    fun `test map to note - FLAT`() {
        assertEquals("C", C.toNoteName(FLAT))
        assertEquals("Db", CSharp.toNoteName(FLAT))
        assertEquals("D", D.toNoteName(FLAT))
        assertEquals("Eb", DSharp.toNoteName(FLAT))
        assertEquals("E", E.toNoteName(FLAT))
        assertEquals("F", F.toNoteName(FLAT))
        assertEquals("Gb", FSharp.toNoteName(FLAT))
        assertEquals("G", G.toNoteName(FLAT))
        assertEquals("Ab", GSharp.toNoteName(FLAT))
        assertEquals("A", A.toNoteName(FLAT))
        assertEquals("Bb", Bb.toNoteName(FLAT))
        assertEquals("B", B.toNoteName(FLAT))
    }
}