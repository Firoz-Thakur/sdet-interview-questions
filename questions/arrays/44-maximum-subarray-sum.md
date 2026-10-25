# 44. Maximum Subarray Sum

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `maxSubArray` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the largest sum of a NONEMPTY contiguous subarray in a nonempty integer array.

## Example

```text
[-2,1,-3,4,-1,2,1,-5,4] → 6
```

## Answer and approach

Kadane's algorithm drops a negative running prefix, while recording the best sum before resetting.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static long maxSubArray(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Array must not be empty");
        long max = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All negative; one element; large total; empty input throws.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
