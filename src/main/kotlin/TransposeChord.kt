import java.util.regex.Pattern

class TransposeChord {

    private val chordNotesPattern = Pattern.compile(chordNotesRegex)

    operator fun invoke(
        chord: String,
        semitones: Semitones,
        preferredModifier: Modifier
    ): String =
        chordNotesPattern
            .matcher(chord)
            .replaceAll { match ->
                match
                    .group()
                    .toKey()
                    ?.let { key -> (key + semitones).toNoteName(preferredModifier) }
                    ?: match.group()
            }

    companion object {
        private const val chordNotesRegex = "[A-G](##?|bb?)?"
    }
}