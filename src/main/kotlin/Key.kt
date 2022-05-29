enum class Key {
    C, CSharp, D, DSharp, E, F, FSharp, G, GSharp, A, Bb, B;

    operator fun plus(semitones: Semitones): Key {
        val mineIndex = keySequence.indexOf(this)
        val targetIndex = mineIndex + semitones

        val transposedKeyIndex = when {
            targetIndex < 0 -> targetIndex + keySequence.size
            targetIndex <= keySequence.lastIndex -> targetIndex
            else -> targetIndex - keySequence.size
        }
        return keySequence[transposedKeyIndex]
    }

    operator fun minus(semitones: Semitones): Key = plus(semitones * -1)

    infix fun diff(other: Key): Int {
        val mineIndex = keySequence.indexOf(this)
        val otherIndex = keySequence.indexOf(other)

        return if (mineIndex > otherIndex) {
            mineIndex - otherIndex
        } else {
            otherIndex - mineIndex
        }
    }

    companion object {
        private val keySequence = listOf(C, CSharp, D, DSharp, E, F, FSharp, G, GSharp, A, Bb, B)
    }
}