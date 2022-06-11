package com.dosei.music.ktransposer

/**
 * A transposer class for kotlin.
 *
 * @param chordPatternRegex the regex pattern used to recognize chords along with lyrics (change if you want some custom formats).
 */
class KTransposer(
    chordPatternRegex: String = Transpose.fileChordsQuery,
) {
    private val transposeWholeSong: Transpose = Transpose.create(chordPatternRegex)
    private val transposeSingleChord: TransposeChord = TransposeChord.create()

    /**
     * Transposes a single note.
     *
     * Samples:
     * - "C" + 2 semitones = "D"
     * - "E" - 3 semitones = "C#"
     *
     * @param note the subject note to be transposed
     * @param semitones the semitones diff between original key and transposed key
     * @param preferredModifier modifier used to format the result of transposer
     * @throws [InvalidKeyException] when the note is invalid (like "P")
     */
    fun transposeNote(
        note: String,
        semitones: Semitones,
        preferredModifier: NoteModifier = NoteModifier.AUTO
    ): String {
        val key = note.toKey()
        return (key + semitones).toNoteName(preferredModifier)
    }

    /**
     * Transposes a single chord.
     *
     * Samples:
     * - "Cm7" + 2 semitones = "Dm7"
     * - "E7+" - 3 semitones = "C#7+"
     * - "Jm7" - 3 semitones = "Jm7" ("J" is not a valid note, so, it's ignored)
     *
     * @param chord the subject chord to be transposed
     * @param semitones the semitones diff between original key and transposed key
     * @param preferredModifier modifier used to format the result of transposer
     */
    fun transposeChord(
        chord: String,
        semitones: Semitones,
        preferredModifier: NoteModifier = NoteModifier.AUTO
    ): String =
        transposeSingleChord(
            chord = chord,
            semitones = semitones,
            preferredModifier = preferredModifier
        )

    /**
     * Transposes a whole song.
     *
     * Sample:
     *
     * ```
     * Bm          Em7
     * The falling leaves
     * ```
     * Adding **4** semitones, results in:
     *
     * ```
     * D#m         G#m7
     * The falling leaves
     * ```
     *
     * Invalid chords or keys are ignored, like "Tm7".
     *
     * @param song the song lyrics with its chords
     * @param semitones the semitones diff between original key and transposed key
     * @param preferredModifier modifier used to format the result of transposer
     */
    fun transposeSong(
        song: String,
        semitones: Semitones,
        preferredModifier: NoteModifier = NoteModifier.AUTO
    ): String =
        transposeWholeSong(
            source = song,
            semitones = semitones,
            preferredModifier = preferredModifier
        )
}

typealias Semitones = Int