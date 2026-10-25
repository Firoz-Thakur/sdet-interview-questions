# 21. Missing Number From 1 to N

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `missingNumber` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given n and exactly n-1 DISTINCT values in 1..n, return the missing value. Range and uniqueness are input preconditions.

## Example

```text
n=6, [1,2,3,4,6] → 5
```

## Answer and approach

XOR all expected and actual values so paired values cancel, avoiding arithmetic-sum overflow.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int missingNumber(int n, int[] arr) {
        if (n < 1 || arr.length != n - 1) throw new IllegalArgumentException("Need n-1 values");
        int answer = n;
        for (int i = 0; i < arr.length; i++) answer ^= (i + 1) ^ arr[i];
        return answer;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Missing 1; missing n; n=1; wrong input length throws.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
