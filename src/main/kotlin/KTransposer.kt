class KTransposer(
    chordPatternRegex: String = Transpose.fileChordsQuery,
    private val transposeWithLyrics: Transpose = Transpose(chordPatternRegex),
    private val transposeSingleChord: TransposeChord = TransposeChord()
) {

    fun transposeNote(
        note: String,
        semitones: Semitones,
        preferredModifier: Modifier = Modifier.AUTO
    ): String {
        val key = note.toKey() ?: throw InvalidKeyException(note)
        return (key + semitones).toNoteName(preferredModifier)
    }

    fun transposeChord(
        chord: String,
        semitones: Semitones,
        preferredModifier: Modifier = Modifier.AUTO
    ): String =
        transposeSingleChord(
            chord = chord,
            semitones = semitones,
            preferredModifier = preferredModifier
        )

    fun transposeChordsWithLyrics(
        source: String,
        semitones: Semitones,
        preferredModifier: Modifier = Modifier.AUTO
    ): String =
        transposeWithLyrics(
            source = source,
            semitones = semitones,
            preferredModifier = preferredModifier
        )
}

typealias Semitones = Int