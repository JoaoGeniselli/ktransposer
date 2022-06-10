class TransposeChord private constructor() {

    private val chordNotesPattern = chordNotesRegex.toRegex()

    operator fun invoke(
        chord: String,
        semitones: Semitones,
        preferredModifier: NoteModifier
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
        private const val chordNotesRegex = "[A-G](##?|bb?)?"

        /**
         * Static factory method.
         *
         * Creates a [TransposeChord] instance.
         */
        fun create() = TransposeChord()
    }
}