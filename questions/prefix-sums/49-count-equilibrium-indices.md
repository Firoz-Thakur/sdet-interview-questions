# 49. Count Equilibrium Indices

- **Pattern:** prefix-sums
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `balancedRuns` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Count indices where the sum strictly to the left equals the sum strictly to the right. Exclude the element at the index from both sums.

## Example

```text
[2,1,3,1,2] → 1
```

## Answer and approach

Start with the full right sum; subtract the current element before comparison, then add it to the left sum.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int balancedRuns(int[] times) {
        long right = 0, left = 0;
        for (int value : times) right += value;
        int count = 0;
        for (int value : times) {
            right -= value;
            if (left == right) count++;
            left += value;
        }
        return count;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty array; singleton counts as one; zeros; large sums.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
