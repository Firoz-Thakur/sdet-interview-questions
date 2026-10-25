# 24. First Index of a Substring

- **Pattern:** strings
- **Interview provenance:** Apple — a nearby comment says "apple interview question"; the association to this specific method is ambiguous
- **Original method(s):** `getFirstIndexOfSubstring` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the first zero-based starting position of needle in haystack, or -1 if absent. An empty needle matches at 0.

## Example

```text
"hello", "ll" → 2; "abc", "c" → 2
```

## Answer and approach

Try every feasible start INCLUDING the last possible one and compare the prefix there.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int getFirstIndexOfSubstring(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) return i;
        }
        return -1;
    }
```

## Complexity

- **Time:** O((n-m+1) × m) when m≤n.
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Absent needle; empty needle; full-string match; needle longer than input.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
