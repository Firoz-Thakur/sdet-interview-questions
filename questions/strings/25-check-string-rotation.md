# 25. Check String Rotation

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `isRotation` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return whether the second string is a cyclic rotation of the first; lengths must match.

## Example

```text
"waterbottle", "erbottlewat" → true
```

## Answer and approach

Every rotation appears in two copies of the original string. Search the doubled string.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String combined = s1 + s1;
        return combined.contains(s2);
    }
```

## Complexity

- **Time:** O(n²) conservative substring-search bound.
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Both empty; unequal lengths; reversal is not generally rotation.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
