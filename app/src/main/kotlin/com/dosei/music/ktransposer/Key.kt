package com.dosei.music.ktransposer

import kotlin.math.max
import kotlin.math.min

/**
 * Represents a key from musical scale.
 * It knows the scale order for transposition logic.
 */
enum class Key {
    C, CSharp, D, DSharp, E, F, FSharp, G, GSharp, A, Bb, B;

    /**
     * Sums semitones to a Key.
     *
     * For example:
     *
     * C + 2 = D
     *
     * C + 5 = F
     * @param semitones amount of semitones to transpose. It can be positive or negative.
     */
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

    /**
     * Subtracts semitones to Key.
     *
     * For example:
     *
     * C - 1 = B
     *
     * C - 4 = G#
     * @param semitones amount of semitones to transpose. It can be positive or negative.
     */
    operator fun minus(semitones: Semitones): Key = plus(semitones * -1)

    /**
     * Calculates the diff in semitones from a key to another key.
     *
     * @param other the counterpart Key.
     */
    infix fun diff(other: Key): Int {
        val mineIndex = keySequence.indexOf(this)
        val otherIndex = keySequence.indexOf(other)

        return max(mineIndex, otherIndex) - min(mineIndex, otherIndex)
    }

    companion object {
        private val keySequence = listOf(C, CSharp, D, DSharp, E, F, FSharp, G, GSharp, A, Bb, B)
    }
}