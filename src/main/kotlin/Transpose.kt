class Transpose private constructor(pattern: String = fileChordsQuery) {

    private val chordsPattern: Regex = pattern.toRegex()
    private val transposeChord = TransposeChord.create()

    operator fun invoke(
        semitones: Semitones,
        source: CharSequence,
        preferredModifier: NoteModifier
    ): String =
        chordsPattern
            .replace(source) { result ->
                transposeChord(
                    chord = result.value,
                    semitones = semitones,
                    preferredModifier = preferredModifier
                )
            }

    companion object {
        const val fileChordsQuery =
            "[A-G](##?|bb?)?((m|\\+|dim|º)?\\d?\\d?M?)?(/[A-G](##?|bb?)?)?(\\(b5\\))?(\r?\n|( (?![A-Za-zÀ-ÿ\\d_])|\$))"

        /**
         * Static factory method.
         *
         * Creates a [Transpose] instance with chords pattern.
         */
        fun create(pattern: String = fileChordsQuery) = Transpose(pattern)
    }
}