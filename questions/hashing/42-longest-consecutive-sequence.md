# 42. Longest Consecutive Sequence

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `longestConsecutive` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the longest run of consecutive distinct integer values in any order. Duplicates do not extend a run; preserve input order.

## Example

```text
[100,4,200,1,3,2] → 4
```

## Answer and approach

Put values in a set and expand only from values without a predecessor. Guard integer boundaries.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int longestConsecutive(int[] arr) {
        Set<Integer> values = new HashSet<>();
        for (int value : arr) values.add(value);
        int best = 0;
        for (int value : values) {
            if (value != Integer.MIN_VALUE && values.contains(value - 1)) continue;
            int current = value, length = 1;
            while (current != Integer.MAX_VALUE && values.contains(current + 1)) { current++; length++; }
            best = Math.max(best, length);
        }
        return best;
    }
```

## Complexity

- **Time:** O(n) expected.
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Duplicates; empty array; integer minimum/maximum.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
