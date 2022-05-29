import junit.framework.TestCase.assertEquals
import org.junit.Test

internal class TransposeChordTest {

    @Test
    fun `test transpose chord negative`() {
        val result = TransposeChord().invoke(chord = "Cm7/Bb", semitones = -2, preferredModifier = preferredModifier)
        assertEquals("Bbm7/G#", result)
    }

    @Test
    fun `test transpose chord positive`() {
        val result = TransposeChord().invoke(chord = "D#7+", semitones = 5, preferredModifier = preferredModifier)
        assertEquals("G#7+", result)
    }

}
