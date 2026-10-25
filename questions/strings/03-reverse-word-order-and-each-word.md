# 03. Reverse Word Order and Each Word

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `revWordsWithCharater` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Reverse both the order of words and the characters within each word. Normalize whitespace to one separating space.

## Example

```text
"apple banana kiwi" → "iwik ananab elppa"
```

## Answer and approach

Visit words from last to first and reverse each word.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String revWordsWithCharater(String s) {
        if (s.isBlank()) return "";
        String[] words = s.trim().split("\\s+");
        StringJoiner result = new StringJoiner(" ");
        for (int i = words.length - 1; i >= 0; i--) result.add(reverseString(words[i]));
        return result.toString();
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Blank input; one word; multiple spaces.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
