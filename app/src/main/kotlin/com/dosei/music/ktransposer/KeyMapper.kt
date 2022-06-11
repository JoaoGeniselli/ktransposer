package com.dosei.music.ktransposer

import com.dosei.music.ktransposer.Key.*
import com.dosei.music.ktransposer.NoteModifier.*

fun String.toKey(): Key =
    when (this) {
        "B#", "C" -> C
        "C#", "Db" -> CSharp
        "D" -> D
        "D#", "Eb" -> DSharp
        "Fb", "E" -> E
        "E#", "F" -> F
        "F#", "Gb" -> FSharp
        "G" -> G
        "G#", "Ab" -> GSharp
        "A" -> A
        "A#", "Bb" -> Bb
        "B", "Cb" -> B
        else -> throw InvalidKeyException(this)
    }

fun String.toKeyOrNull(): Key? {
    val result = try {
        toKey()
    } catch (e: InvalidKeyException) {
        null
    }
    return result
}

fun Key.toNoteName(preferredModifier: NoteModifier = AUTO): String =
    when (preferredModifier) {
        AUTO -> {
            if (this == Bb)
                toFlatNoteName()
            else {
                toSharpNoteName()
            }
        }
        SHARP -> toSharpNoteName()
        FLAT -> toFlatNoteName()
    }

private fun Key.toSharpNoteName() =
    when (this) {
        C -> "C"
        CSharp -> "C#"
        D -> "D"
        DSharp -> "D#"
        E -> "E"
        F -> "F"
        FSharp -> "F#"
        G -> "G"
        GSharp -> "G#"
        A -> "A"
        Bb -> "A#"
        B -> "B"
    }

private fun Key.toFlatNoteName(): String =
    when (this) {
        C -> "C"
        CSharp -> "Db"
        D -> "D"
        DSharp -> "Eb"
        E -> "E"
        F -> "F"
        FSharp -> "Gb"
        G -> "G"
        GSharp -> "Ab"
        A -> "A"
        Bb -> "Bb"
        B -> "B"
    }