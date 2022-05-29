import junit.framework.TestCase.assertEquals
import org.junit.Test

internal class KeyTest {

    @Test
    fun `test plus`() {
        val key = Key.C

        val third = key + 4
        val fifth = key + 7
        val minorNinth = key + 13

        assertEquals(Key.E, third)
        assertEquals(Key.G, fifth)
        assertEquals(Key.CSharp, minorNinth)
    }

    @Test
    fun `test minus`() {
        val key = Key.C

        val minorSeventh = key - 2
        val fifth = key - 5
        val second = key - 10

        assertEquals(Key.Bb, minorSeventh)
        assertEquals(Key.G, fifth)
        assertEquals(Key.D, second)
    }

    @Test
    fun `test diff`() {
        val key = Key.C

        val diffBb = key diff Key.Bb
        val diffG = key diff Key.G
        val diffD = key diff Key.D

        assertEquals(10, diffBb)
        assertEquals(7, diffG)
        assertEquals(2, diffD)
    }
}