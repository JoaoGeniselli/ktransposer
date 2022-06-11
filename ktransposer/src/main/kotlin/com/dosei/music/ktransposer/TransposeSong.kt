package com.dosei.music.ktransposer

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
 */
class TransposeSong constructor(
    private val chordsPattern: Regex = chordsRegex.toRegex(),
    private val transposeChord: TransposeChord = TransposeChord()
) {

    /**
     * Invokes the song transposition.
     *
     * @param song the song lyrics with its chords
     * @param semitones the semitones diff between original key and transposed key
     * @param preferredModifier modifier used to format the result of transposer
     */
    operator fun invoke(
        song: CharSequence,
        semitones: Semitones,
        preferredModifier: NoteModifier
    ): String =
        chordsPattern
            .replace(song) { result ->
                transposeChord(
                    chord = result.value,
                    semitones = semitones,
                    preferredModifier = preferredModifier
                )
            }

    companion object {
        @Suppress("MaxLineLength")
        const val chordsRegex =
            "[A-G](##?|bb?)?((-|M|m|\\+|dim|º)?\\d?\\d?M? ?\\d?\\d?M?)?\\+?(\\((add)?(##?|bb?)?\\d?\\d?\\+? ?(##?|bb?)?\\d?\\d?\\+?\\))?(/[A-G](##?|bb?)?)?(\\(b5\\))?(\r?\n|( (?![A-Za-zÀ-ÿ\\d_])|\$))"

    }
}
