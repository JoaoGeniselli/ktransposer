import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

internal class TransposeTest {

    private val pattern = Transpose.fileChordsQuery.toPattern()

    @Test
    fun `test major pattern recognition`() {
        assertPattern("CM")
        assertPattern("CM7+")
        assertPattern("C7M")
        assertPattern("CM7")
        assertPattern("CM/E")
        assertPattern("CM/G")
        assertPattern("CM(add9)")
        assertPattern("CM5+")
        assertPattern("CM6")
        assertPattern("CM6/G")
        assertPattern("CM69")
        assertPattern("CM69/G")
        assertPattern("CM69/E")
        assertPattern("CM7+/E")
        assertPattern("CM7+/G")
        assertPattern("CM7+(6)")
        assertPattern("CM7+(#5)")
        assertPattern("CM7+(#5)/E")
        assertPattern("CM7+(9)")
        assertPattern("CM7+(9)/E")
        assertPattern("CM7+(9)/G")
        assertPattern("CM7+(6 9)")
        assertPattern("CM7+(9)/B")
        assertPattern("CM7+(#11)")
        assertPattern("CM7+(#11)/G")
        assertPattern("CM7+(9 #11)")
        assertPattern("CM7+(9 #11)/G")
        assertPattern("CM4")
        assertPattern("CM7/E")
        assertPattern("CM7/G")
        assertPattern("CM/Bb")
        assertPattern("CM7(b5)")
        assertPattern("CM7(b5)/E")
        assertPattern("CM7(#11)")
        assertPattern("CM7(9 #11)")
        assertPattern("CM7(#11 13)")
        assertPattern("CM7(#5)")
        assertPattern("CM7(#5)/E")
        assertPattern("CM7(#5)/Bb")
        assertPattern("CM7(b13)")
        assertPattern("CM7(#5 9)")
        assertPattern("CM7(13)")
        assertPattern("CM7(9)")
        assertPattern("CM7(9 13)")
        assertPattern("CM7(b9)")
        assertPattern("CM7(#5 b9)")
        assertPattern("CM7(b9 b13)")
        assertPattern("CM7(b5 b9)")
        assertPattern("CM7(b9 b11)")
        assertPattern("CM7(b9 13)")
        assertPattern("CM7(#9)")
        assertPattern("CM7(#9)/G")
        assertPattern("CM7(#5 #9)")
        assertPattern("CM7(#9 #11)")
        assertPattern("CM7(b5 #9)")
        assertPattern("CM7 4")
        assertPattern("CM7 4(9)")
        assertPattern("CM7 4(13)")
        assertPattern("CM7 4(9 13)")
        assertPattern("CM7 4(b9)")
        assertPattern("C")
        assertPattern("C7+")
        assertPattern("C7")
        assertPattern("C/E")
        assertPattern("C/G")
        assertPattern("C(add9)")
        assertPattern("C5+")
        assertPattern("C6")
        assertPattern("C6/G")
        assertPattern("C69")
        assertPattern("C69/G")
        assertPattern("C69/E")
        assertPattern("C7+/E")
        assertPattern("C7+/G")
        assertPattern("C7+(6)")
        assertPattern("C7+(#5)")
        assertPattern("C7+(#5)/E")
        assertPattern("C7+(9)")
        assertPattern("C7+(9)/E")
        assertPattern("C7+(9)/G")
        assertPattern("C7+(6 9)")
        assertPattern("C7+(9)/B")
        assertPattern("C7+(#11)")
        assertPattern("C7+(#11)/G")
        assertPattern("C7+(9 #11)")
        assertPattern("C7+(9 #11)/G")
        assertPattern("C4")
        assertPattern("C7/E")
        assertPattern("C7/G")
        assertPattern("C/Bb")
        assertPattern("C7(b5)")
        assertPattern("C7(b5)/E")
        assertPattern("C7(#11)")
        assertPattern("C7(9 #11)")
        assertPattern("C7(#11 13)")
        assertPattern("C7(#5)")
        assertPattern("C7(#5)/E")
        assertPattern("C7(#5)/Bb")
        assertPattern("C7(b13)")
        assertPattern("C7(#5 9)")
        assertPattern("C7(13)")
        assertPattern("C7(9)")
        assertPattern("C7(9 13)")
        assertPattern("C7(b9)")
        assertPattern("C7(#5 b9)")
        assertPattern("C7(b9 b13)")
        assertPattern("C7(b5 b9)")
        assertPattern("C7(b9 b11)")
        assertPattern("C7(b9 13)")
        assertPattern("C7(#9)")
        assertPattern("C7(#9)/G")
        assertPattern("C7(#5 #9)")
        assertPattern("C7(#9 #11)")
        assertPattern("C7(b5 #9)")
        assertPattern("C7 4")
        assertPattern("C7 4(9)")
        assertPattern("C7 4(13)")
        assertPattern("C7 4(9 13)")
        assertPattern("C7 4(b9)")
    }

    @Test
    fun `test minor patterns`() {
        assertPattern("Cm")
        assertPattern("Cm7")
        assertPattern("Cm/Eb")
        assertPattern("Cm/G")
        assertPattern("Cm(add9)")
        assertPattern("Cm6")
        assertPattern("Cm6/Eb")
        assertPattern("Cm6/G")
        assertPattern("Cm(6 9)")
        assertPattern("Cm(6 9)/Eb")
        assertPattern("Cm7/G")
        assertPattern("Cm7(9)")
        assertPattern("Cm7(9)/G")
        assertPattern("Cm/Bb")
        assertPattern("Cm7(b5)")
        assertPattern("Cm7(11)")
        assertPattern("Cm7(9 11)")
        assertPattern("Cm(7+)")
        assertPattern("Cm(6 7+)")
        assertPattern("Cm(7+ 9)")

        assertPattern("F#-")
        assertPattern("F#-7")
        assertPattern("F#-/A")
        assertPattern("F#-/C#")
        assertPattern("F#-(add9)")
        assertPattern("F#-6")
        assertPattern("F#-6/A")
        assertPattern("F#-6/C#")
        assertPattern("F#-(6 9)")
        assertPattern("F#-(6 9)/A")
        assertPattern("F#-7/C#")
        assertPattern("F#-7(9)")
        assertPattern("F#-7(9)/C#")
        assertPattern("F#-/E")
        assertPattern("F#-7(b5)")
        assertPattern("F#-7(11)")
        assertPattern("F#-7(9 11)")
        assertPattern("F#-(7+)")
        assertPattern("F#-(6 7+)")
        assertPattern("F#-(7+ 9)")
    }

    @Test
    fun `test dim patterns`() {
        assertPattern("A#dim")
        assertPattern("A#dim(b13)")
        assertPattern("A#dim(7+)")
    }

    private fun assertPattern(chord: String) {
        val matcher = pattern.matcher(chord)
        assertTrue(matcher.find())
        assertEquals(chord, matcher.group())
    }

    @Test
    fun `test transpose`() {
        val autumnLeaves = """
            Bm             Em7
            The falling leaves
            A7             D7M
            Drift by my window
            G7M          C#m7(b5)
            The autumn leaves
            F#7           Bm
            Of red and gold
        """.trimIndent()

        val result = Transpose.create().invoke(
            semitones = 4,
            source = autumnLeaves,
            preferredModifier = NoteModifier.AUTO
        )

        val expected = """
            D#m             G#m7
            The falling leaves
            C#7             F#7M
            Drift by my window
            B7M          Fm7(b5)
            The autumn leaves
            Bb7           D#m
            Of red and gold
        """.trimIndent()

        assertEquals(expected, result)
    }


}