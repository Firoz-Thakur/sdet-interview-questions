# 06. Second Smallest Distinct Element

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `secondMin` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the second smallest DISTINCT integer. Throw IllegalArgumentException if fewer than two distinct values exist.

## Example

```text
[1,1,3,5] → 3
```

## Answer and approach

A sorted set removes duplicates; select the successor of its first value. A follow-up is a one-pass O(n), O(1) implementation.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int secondMin(int[] a) {
        TreeSet<Integer> values = new TreeSet<>();
        for (int value : a) values.add(value);
        if (values.size() < 2) throw new IllegalArgumentException("Need two distinct values");
        return values.higher(values.first());
    }
```

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All equal; minimum integer; duplicates.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
