# 07. Second Largest Distinct Element

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `secondmax` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the second largest DISTINCT integer. Throw IllegalArgumentException if fewer than two distinct values exist.

## Example

```text
[9,9,7,1] → 7
```

## Answer and approach

Build a sorted set and select the predecessor of its last value. Discuss a one-pass alternative in interviews.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int secondmax(int[] a) {
        TreeSet<Integer> values = new TreeSet<>();
        for (int value : a) values.add(value);
        if (values.size() < 2) throw new IllegalArgumentException("Need two distinct values");
        return values.lower(values.last());
    }
```

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All equal; negative values; maximum integer.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
