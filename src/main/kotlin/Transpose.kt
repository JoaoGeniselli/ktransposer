import java.util.regex.Pattern

class Transpose(pattern: String = fileChordsQuery) {

    private val chordsPattern: Pattern = Pattern.compile(pattern)
    private val transposeChord = TransposeChord()

    operator fun invoke(
        semitones: Semitones,
        source: CharSequence,
        preferredModifier: Modifier
    ): String =
        chordsPattern
            .matcher(source)
            .replaceAll { result -> transposeChord(result.group(), semitones, preferredModifier) }

    companion object {
        const val fileChordsQuery =
            "[A-G](##?|bb?)?((m|\\+|dim|º)?\\d?\\d?M?)?(/[A-G](##?|bb?)?)?(\\(b5\\))?(\r?\n|( (?![A-Za-zÀ-ÿ\\d_])|\$))"
    }
}