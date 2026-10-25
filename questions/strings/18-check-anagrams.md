# 18. Check Anagrams

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `isAnagram` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return whether two strings have exactly the same character multiplicities. Comparison is case-sensitive and includes spaces.

## Example

```text
"listen", "silent" → true
```

## Answer and approach

Sort both character arrays and compare them.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static Boolean isAnagram(String a, String b) {
        char a_[] = a.toCharArray();
        char b_[] = b.toCharArray();
        Arrays.sort(a_);
        Arrays.sort(b_);
        return Arrays.equals(a_, b_);
    }
```

## Complexity

- **Time:** O(n log n + m log m).
- **Space:** O(n+m).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Different lengths; repeated letters; mixed case.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
