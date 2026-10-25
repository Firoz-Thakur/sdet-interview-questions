# 01. Reverse a String

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `reverseString` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the input characters in reverse order. Inputs for character-oriented exercises are ASCII unless stated otherwise.

## Example

```text
"aakash" → "hsakaa"
```

## Answer and approach

Build the result using StringBuilder reversal.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; one character; repeated characters.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
