# 14. Run-Length String Compression

- **Pattern:** strings
- **Interview provenance:** Acceldata — user-reported in the supplied notes
- **Original method(s):** `stringCompression` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Encode each consecutive run as its character followed by its decimal count. Runs separated by other characters remain separate.

## Example

```text
"aaabbvvfffddaa" → "a3b2v2f3d2a2"
```

## Answer and approach

Track a run length and emit it when the character changes or input ends. This is run encoding, not a guaranteed shorter or unambiguous format.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String stringCompression(String s) {
        StringBuilder ss = new StringBuilder();
        int c = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                c++;
            } else {
                ss.append(s.charAt(i - 1));
                ss.append(c);
                c = 1;
            }
        }
        return ss.toString();
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; singleton runs; counts above 9; digit characters.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
