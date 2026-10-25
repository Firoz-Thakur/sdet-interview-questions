# 02. Reverse Word Order

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `revWords` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Reverse the order of whitespace-separated words. Trim outer whitespace and use one space between output words.

## Example

```text
"apple banana kiwi" → "kiwi banana apple"
```

## Answer and approach

Split on whitespace, reverse the word array, and join.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String revWords(String s) {
        if (s.isBlank()) return "";
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Blank input; tabs; repeated spaces.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
