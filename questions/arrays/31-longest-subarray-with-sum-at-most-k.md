# 31. Longest Subarray With Sum at Most K

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `longestSubArray` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the largest length of a contiguous subarray with sum ≤k. Values may be negative; return 0 if none qualifies.

## Example

```text
[1,2,4,3,5,6,3], k=3 → 2
```

## Answer and approach

Enumerate each start and running end sum. Do not use the usual positive-only sliding window when negatives are allowed.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int longestSubArray(int[] arr, int k) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
```

## Complexity

- **Time:** O(n²).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Negative values; negative k; empty input; qualifying whole array.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
