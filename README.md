# KTransposer

A simple chord and note transposer for kotlin applications.

It exposes an API named `KTransposer` that allows developers transpose single notes, chords, or even whole songs.

## Samples:

### Transpose a Single Note

```kotlin

val transposer = KTransposer()
val result = transposer.transposeNote(
    note = "G",
    semitones = -2
)

// Result: "A"

```

### Transpose a Single Chord

```kotlin

val transposer = KTransposer()
val result = transposer.transposeChord(
    chord = "Dm7",
    semitones = 3
)

// Result: "Fm7"

```

### Transpose a Whole Song

```kotlin

val autumnLeaves = """
    Bm             Em7
    The falling leaves
    A7             D7M
    Drift by my window
    G7M          C#m7(b5)
    The autumn leaves
    F#7           Bm
    Of red and gold
""".trimIndent()

val transposer = KTransposer()
val result = transposer.transposeSong(
    song = autumnLeaves,
    semitones = 4
)

// Result:
// """
//  D#m             G#m7
//  The falling leaves
//  C#7             F#7M
//  Drift by my window
//  B7M          Fm7(b5)
//  The autumn leaves
//  Bb7           D#m
//  Of red and gold
// """

```

### Explicit Note Modifier

You can control if the result will show `flat (b)` or `sharp (#)` notes using the parameter `preferredModifier`.

```kotlin

val transposer = KTransposer()
val sharpResult = transposer.transposeNote(
    note = "C",
    semitones = 3, 
    preferredModifier = NoteModifier.SHARP 
)
val flatResult = transposer.transposeNote(
    note = "C",
    semitones = 3,
    preferredModifier = NoteModifier.FLAT
)

// Sharp Result: "D#"

// Flat Result: "Eb"

// * This logic can be applied to chords and songs too.

```

### Custom Chord Regex

The default regex covers many of commonly used chord formats. [You can check it here](https://github.com/JoaoGeniselli/ktransposer/blob/master/src/main/kotlin/Transpose.kt). 
But if you need any advanced chord format, you can create a custom regex and pass it to `KTransposer` constructor param `chordPatternRegex`. 

```kotlin

val neverGonnaGiveYouUp = """
          Gb7Maj         Ab 
    Never gonna give you up
                F-      Bb-                        
    Never gonna let you down
          Gb7Maj    Ab         F-     Bb-      
    Never gonna run around and desert you
""".trimIndent()

val myCustomRegex: String = "... something you need ..."
val transposer = KTransposer(myCustomRegex)
val result = transposer.transposeSong(
    song = neverGonnaGiveYouUp,
    semitones = 1
)

// Result:
// """
//        G7Maj          A 
//  Never gonna give you up
//              F#-     B-                        
//  Never gonna let you down
//        G7Maj     A          F#-    B-      
//  Never gonna run around and desert you
// """


```

If you see any bugs or improvements in this library, please submit [a new issue here](https://github.com/JoaoGeniselli/ktransposer/issues/new).