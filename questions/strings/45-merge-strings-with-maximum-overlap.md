# 45. Merge Strings With Maximum Overlap

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `mergeStrings` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Append the second string to the first while removing the longest suffix-of-first/prefix-of-second overlap. This is a directional merge, not the general shortest-superstring problem.

## Example

```text
"aabcx", "cxfghj" → "aabcxfghj"
```

## Answer and approach

Try overlap lengths from largest to smallest and append only the unmatched suffix.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String mergeStrings(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = minLen; i > 0; i--) {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i))) {
                return s1 + s2.substring(i);
            }
        }
        return s1 + s2;
    }
```

## Complexity

- **Time:** O(min(n,m)² + n+m).
- **Space:** O(n+m).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

No overlap; full overlap; empty strings.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
