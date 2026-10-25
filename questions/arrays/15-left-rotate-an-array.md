# 15. Left Rotate an Array

- **Pattern:** arrays
- **Interview provenance:** Acceldata — user-reported in the supplied notes
- **Original method(s):** `LeftRotate` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return a new array rotated left by nonnegative k positions. Preserve the input and normalize k modulo array length.

## Example

```text
[1,2,3,4,5], k=1 → [2,3,4,5,1]
```

## Answer and approach

Output index i reads source index (i+k) modulo n.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int[] LeftRotate(int[] arr, int k) {
        if (k < 0) throw new IllegalArgumentException("k must be nonnegative");
        int n = arr.length;
        int[] result = new int[n];
        if (n == 0) return result;
        k %= n;
        for (int i = 0; i < n; i++) result[i] = arr[(int) (((long) i + k) % n)];
        return result;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty array; k=0; k larger than length; negative k throws.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
