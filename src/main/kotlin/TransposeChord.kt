import java.util.regex.Pattern

class TransposeChord private constructor() {

    private val chordNotesPattern = Pattern.compile(chordNotesRegex)

    operator fun invoke(
        chord: String,
        semitones: Semitones,
        preferredModifier: NoteModifier
    ): String =
        chordNotesPattern
            .matcher(chord)
            .replaceAll { match ->
                match
                    .group()
                    .toKeyOrNull()
                    ?.let { key -> (key + semitones).toNoteName(preferredModifier) }
                    ?: match.group()
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