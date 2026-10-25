# 16. Right Rotate an Array

- **Pattern:** arrays
- **Interview provenance:** Acceldata — user-reported in the supplied notes
- **Original method(s):** `RightRotate` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return a new array rotated right by nonnegative k positions. Preserve the input.

## Example

```text
[1,2,3,4,5], k=2 → [4,5,1,2,3]
```

## Answer and approach

Translate right rotation into an equivalent left rotation.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int[] RightRotate(int[] arr, int k) {
        if (k < 0) throw new IllegalArgumentException("k must be nonnegative");
        if (arr.length == 0) return new int[0];
        return LeftRotate(arr, (arr.length - k % arr.length) % arr.length);
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty array; k divisible by length; very large k.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
