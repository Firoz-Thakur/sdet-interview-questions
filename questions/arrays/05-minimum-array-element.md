# 05. Minimum Array Element

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `minnumber` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the smallest value in a nonempty integer array.

## Example

```text
[6,5,9,1,8] → 1
```

## Answer and approach

Track the smallest value seen during one scan.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int minnumber(int[] a) {
        if (a.length == 0) throw new IllegalArgumentException("Array must not be empty");
        int min = a[0];
        for (int value : a) min = Math.min(min, value);
        return min;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Negative values; one value; empty input throws.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
