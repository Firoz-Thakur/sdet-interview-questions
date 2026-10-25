# 39. Check a Subsequence

- **Pattern:** two-pointers
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `isSubsequence` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return whether all characters of the first string appear in the second in the same order, without requiring contiguity.

## Example

```text
"abc", "abfcd" → true
```

## Answer and approach

Scan the second string and advance the first-string pointer on matches.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
```

## Complexity

- **Time:** O(n+m).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty candidate; repeated letters; candidate longer than text.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
