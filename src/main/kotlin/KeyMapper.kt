fun String.toKey(): Key? =
    when (this) {
        "B#", "C" -> Key.C
        "C#", "Db" -> Key.CSharp
        "D" -> Key.D
        "D#", "Eb" -> Key.DSharp
        "Fb", "E" -> Key.E
        "E#", "F" -> Key.F
        "F#", "Gb" -> Key.FSharp
        "G" -> Key.G
        "G#", "Ab" -> Key.GSharp
        "A" -> Key.A
        "A#", "Bb" -> Key.Bb
        "B", "Cb" -> Key.B
        else -> null
    }

fun Key.toNoteName(preferredModifier: Modifier = Modifier.SHARP): String =
    when (preferredModifier) {
        Modifier.AUTO -> {
            if (this == Key.B)
                toFlatNoteName()
            else {
                toSharpNoteName()
            }
        }
        Modifier.SHARP -> toSharpNoteName()
        Modifier.FLAT -> toFlatNoteName()
    }

private fun Key.toSharpNoteName() =
    when (this) {
        Key.C -> "C"
        Key.CSharp -> "C#"
        Key.D -> "D"
        Key.DSharp -> "D#"
        Key.E -> "E"
        Key.F -> "F"
        Key.FSharp -> "F#"
        Key.G -> "G"
        Key.GSharp -> "G#"
        Key.A -> "A"
        Key.Bb -> "A#"
        Key.B -> "B"
    }

private fun Key.toFlatNoteName(): String =
    when (this) {
        Key.C -> "C"
        Key.CSharp -> "Db"
        Key.D -> "D"
        Key.DSharp -> "Eb"
        Key.E -> "E"
        Key.F -> "F"
        Key.FSharp -> "Gb"
        Key.G -> "G"
        Key.GSharp -> "Ab"
        Key.A -> "A"
        Key.Bb -> "Bb"
        Key.B -> "B"
    }