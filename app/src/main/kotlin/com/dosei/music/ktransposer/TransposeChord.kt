package com.dosei.music.ktransposer

/**
 * Transposes a single chord.
 *
 * Ex.:
 *
 * Cm7 + 2 semitones = Dm7
 *
 * F#7 - 2 semitones = E7
 *
 * @param chordNotesPattern regex that describes how the chord's keys are found. Default value: [chordNotesRegex]
 */
class TransposeChord(
    private val chordNotesPattern: Regex = chordNotesRegex.toRegex()
) {

    /**
     * Invokes the chord transposition.
     *
     * @param chord the chord to be transposed. Ex.: "G#m7"
     * @param semitones the transposition diff in semitones.
     * @param preferredModifier the preferred modifier (# or b) used in the result. Default: [NoteModifier.AUTO]
     */
    operator fun invoke(
        chord: String,
        semitones: Semitones,
        preferredModifier: NoteModifier = NoteModifier.AUTO
    ): String =
        chordNotesPattern
            .replace(chord) { match ->
                match
                    .value
                    .toKeyOrNull()
                    ?.let { key -> (key + semitones).toNoteName(preferredModifier) }
                    ?: match.value
            }

    companion object {
        const val chordNotesRegex = "[A-G](##?|bb?)?"
    }
}