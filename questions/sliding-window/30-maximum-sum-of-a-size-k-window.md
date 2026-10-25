# 30. Maximum Sum of a Size-K Window

- **Pattern:** sliding-window
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `maxSubArraySumOfKWindow` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the largest sum among contiguous subarrays containing exactly k elements, with 1≤k≤n.

## Example

```text
[1,2,4,3,5,6,3], k=2 → 11
```

## Answer and approach

Compute one window, then add the entering value and subtract the leaving value. Accumulate in long.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static long maxSubArraySumOfKWindow(int[] a, int k) {
        if (k <= 0 || k > a.length) throw new IllegalArgumentException("Invalid window size");
        long sum = 0;
        for (int i = 0; i < k; i++) sum += a[i];
        long best = sum;
        for (int i = k; i < a.length; i++) {
            sum += (long) a[i] - a[i - k];
            best = Math.max(best, sum);
        }
        return best;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All negative; k=1; k=n; invalid k throws; large sums.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
